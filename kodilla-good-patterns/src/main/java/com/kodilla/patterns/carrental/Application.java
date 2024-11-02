package com.kodilla.patterns.carrental;

import java.time.LocalDateTime;

public class Application {

  public static void main(String[] args) {
    RentRequestRetriever rentRequestRetriever = new RentRequestRetriever();
    RentRequest rentRequest = rentRequestRetriever.retrieve();

    RentalProcessor rentalProcessor = new RentalProcessor(
        new MailService(), new CarRentalService(), new CarRentalRepository());
    rentalProcessor.process(rentRequest);
  }

}
