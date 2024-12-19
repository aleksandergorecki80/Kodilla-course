package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class OptionalExample {
  public static void main(String[] args) {
    User user = null;
//    User user = new User("User one");

    Optional<User> optionalUser = Optional.ofNullable(user);
    String userName = optionalUser.orElse(new User("***")).getName();
    System.out.println(userName);

    System.out.println("++++++++++++++++++++++++++");

    User user2 = new User("User 2 name");
    Optional<User> optionalUser2 = Optional.ofNullable(user2);
    optionalUser2.ifPresent(usr -> System.out.println(usr.getName()));
  }
}
