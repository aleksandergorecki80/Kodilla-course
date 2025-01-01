package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Forum {
  private final List<ForumUser> forumUsers = new ArrayList<>();

  public Forum() {
    forumUsers.add(new ForumUser(1, "Leah Poole", 'M', LocalDate.of(2007, 1, 7), 15));
    forumUsers.add(new ForumUser(2, "Quincy Vega", 'F', LocalDate.of(1998, 12, 17), 0));
    forumUsers.add(new ForumUser(3, "Avery Moore", 'M', LocalDate.of(1995, 5, 23), 32));
    forumUsers.add(new ForumUser(4, "Jordan Lewis", 'F', LocalDate.of(1990, 8, 15), 2));
    forumUsers.add(new ForumUser(5, "Morgan Riley", 'M', LocalDate.of(1987, 11, 3), 8));
    forumUsers.add(new ForumUser(6, "Sydney Lee", 'F', LocalDate.of(2000, 2, 19), 35));
    forumUsers.add(new ForumUser(7, "Riley Quinn", 'M', LocalDate.of(1993, 9, 5), 60));
    forumUsers.add(new ForumUser(8, "Charlie Harper", 'M', LocalDate.of(2006, 7, 28), 5));
    forumUsers.add(new ForumUser(9, "Taylor Morgan", 'F', LocalDate.of(1985, 3, 11), 15));
    forumUsers.add(new ForumUser(10, "Dakota Jordan", 'F', LocalDate.of(2002, 6, 25), 2));
    forumUsers.add(new ForumUser(11, "Peyton Anderson", 'M', LocalDate.of(1997, 4, 14), 0));
    forumUsers.add(new ForumUser(12, "Casey Bailey", 'F', LocalDate.of(1992, 1, 9), 11));
  }

  public List<ForumUser> getUserList() {
    return new ArrayList<>(forumUsers);
  }

  public static boolean isOlderThan(LocalDate dateOfBirth, LocalDate currentDate, int age) {
    return Period.between(dateOfBirth, currentDate).getYears() > age;
  }
}
