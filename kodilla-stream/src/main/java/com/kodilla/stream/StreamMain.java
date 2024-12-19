package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {
  public static void main(String[] args) {
    Forum forum = new Forum();
    Map<Integer, ForumUser> resultMapOfUsers = forum.getUserList().stream()
        .filter(forumUser -> forumUser.getSex() == 'M')
        .filter(forumUser -> forumUser.getPostCount() > 0)
        .filter(forumUser -> Forum.isOlderThan(forumUser.getDateOfBirth(), LocalDate.now(), 20))
        .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

    resultMapOfUsers.entrySet()
        .forEach(System.out::println);
  }
}

