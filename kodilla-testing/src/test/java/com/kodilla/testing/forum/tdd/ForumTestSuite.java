package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Nested;

@DisplayName("TDD: Forum test suite")
public class ForumTestSuite {
  private static int testCounter = 0;

  @BeforeAll
  public static void beforeAllTests() {
    System.out.println("This is a beginning of all tests");
  }

  @AfterAll
  public static void afterAllTests() {
    System.out.println("All test are finished");
  }

  @BeforeEach
  public void beforeEveryTest() {
    testCounter++;
    System.out.println("Preparing to execute test #" + testCounter);
  }

  @Nested
  @DisplayName("Tests for posts")
  class TestPosts {
    @Test
    void testAddPost(){
      // Given
      ForumUser forumUser = new ForumUser("mrSmith", "John Smith");

      // When
      forumUser.addPost("mrSmith", "Hello everyone, this is my first post");

      // Then
      Assertions.assertEquals(1, forumUser.getPostsQuantity());
    }

    @Test
    void testGetPost(){
      // Given
      ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
      ForumPost thePost = new ForumPost( "Hello everyone, this is my first post", "mrSmith");
      forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

      // When
      ForumPost retrievedPost;
      retrievedPost = forumUser.getPost(0);

      // Then
      Assertions.assertEquals(thePost, retrievedPost);
    }

    @Test
    void testRemovePostNotExisting(){
      // Given
      ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
      ForumPost forumPost = new ForumPost( "Hello everyone, this is my first post", "mrSmith");

      // When
      boolean result = forumUser.removePost(forumPost);

      // Then
      Assertions.assertFalse(result);
    }

    @Test
    void testRemovePost(){
      // Given
      ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
      ForumPost forumPost = new ForumPost( "Hello everyone, this is my first post", "mrSmith");
      forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

      // When
      boolean result = forumUser.removePost(forumPost);

      // Then
      Assertions.assertTrue(result);
      Assertions.assertEquals(0, forumUser.getPostsQuantity());
    }
  }

  @Nested
  @DisplayName("Tests for comments")
  class TestComments {
    @Test
    void testAddComment(){
      // Given
      ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
      ForumPost thePost = new ForumPost( "Hello everyone, this is my first post", "mrSmith");

      // When
      forumUser.addComment(thePost, "mrSmith", "Thank you for all good words");

      // Then
      Assertions.assertEquals(1, forumUser.getCommentsQuantity());
    }

    @Test
    void testGetComment(){
      // Given
      ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
      ForumPost thePost = new ForumPost( "Hello everyone, this is my first post", "mrSmith");
      ForumComment theComment = new ForumComment(thePost, "mrSmith", "Thank you for all good words");

      forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

      // When
      ForumComment retrievedComment = forumUser.getComment(0);

      // Then
      Assertions.assertEquals(theComment, retrievedComment);
    }

    @Test
    void testRemoveCommentNotExisting(){
      // Given
      ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
      ForumPost forumPost = new ForumPost( "Hello everyone, this is my first post", "mrSmith");
      ForumComment theComment = new ForumComment(forumPost, "mrSmith", "Thank you for all good words");

      // When
      boolean result = forumUser.removeComment(theComment);

      // Then
      Assertions.assertFalse(result);
    }

    @Test
    void testRemoveComment(){
      // Given
      ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
      ForumPost forumPost = new ForumPost( "Hello everyone, this is my first post", "mrSmith");
      ForumComment theComment = new ForumComment(forumPost, "mrSmith", "Thank you for all good words");
      forumUser.addComment(forumPost, theComment.getAuthor(), theComment.getCommentBody());

      // When
      boolean result = forumUser.removeComment(theComment);

      // Then
      Assertions.assertTrue(result);
      Assertions.assertEquals(0, forumUser.getCommentsQuantity());
    }
  }
}
