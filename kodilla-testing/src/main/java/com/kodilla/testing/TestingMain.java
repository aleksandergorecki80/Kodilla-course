package com.kodilla.testing;

import com.kodilla.testing.forum.ForumPost;

public class TestingMain {

  public static void main(String[] args) {


    ForumPost forumPost = new ForumPost("Body", "Author");
    ForumPost forumPost2 = new ForumPost("Body", "Author");

    System.out.println(forumPost.getClass());
    System.out.println(ForumPost.class);

  }
}