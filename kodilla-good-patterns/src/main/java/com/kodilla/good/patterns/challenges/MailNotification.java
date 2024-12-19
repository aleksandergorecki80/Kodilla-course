package com.kodilla.good.patterns.challenges;

public class MailNotification implements NotificationService{
  @Override
  public void sendNotification(final User user) {
    System.out.println("Sending email notification to user " + user.getName() );
  }
}
