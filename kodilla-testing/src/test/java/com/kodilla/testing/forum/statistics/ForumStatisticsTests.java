package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("TDD: testing ForumStatistics class")
public class ForumStatisticsTests {
  @Mock
  Statistics statisticsMock;
  private List<String> generateUserName(int quantity) {
    List<String> userNames = new ArrayList<>();
    for (int i = 0; i < quantity; i++) {
      userNames.add("user" + i);
    }
    return userNames;
  }

  @Test
  void calculateAdvStatisticsZeroPosts() {
    // Given
//    Statistics statisticsMock = mock(Statistics.class);
    ForumStatistics forumStatistics = new ForumStatistics();
    List<String> usersNamesList = generateUserName(0);

    when(statisticsMock.userNames()).thenReturn(usersNamesList);
    when(statisticsMock.postCount()).thenReturn(0);
    when(statisticsMock.commentCount()).thenReturn(0);

    // When
    forumStatistics.calculateAdvStatistics(statisticsMock);

    // Then
    assertEquals(0, forumStatistics.getAveragePostsPerUser());
    assertEquals(0, forumStatistics.getAverageCommentsPerUser());
    assertEquals(0, forumStatistics.getAverageCommentsPerPost());
    assertEquals("No user found\nNo posts found\n", forumStatistics.showStatistics());
  }

  @Test
  void calculateAdvStatisticsThousandPosts() {
    // Given
    Statistics statisticsMock = mock(Statistics.class);
    ForumStatistics forumStatistics = new ForumStatistics();
    List<String> usersNamesList = generateUserName(50);

    when(statisticsMock.userNames()).thenReturn(usersNamesList);
    when(statisticsMock.postCount()).thenReturn(1000);
    when(statisticsMock.commentCount()).thenReturn(2500);

    // When
    forumStatistics.calculateAdvStatistics(statisticsMock);

    // Then
    String expectedMessage = "Posts per user: 20\nComments per user: 50\nComments per post: 2\n";
//    assertEquals(20, forumStatistics.getAveragePostsPerUser());
//    assertEquals(50, forumStatistics.getAverageCommentsPerUser());
//    assertEquals(2, forumStatistics.getAverageCommentsPerPost());
//    assertEquals(expectedMessage, forumStatistics.showStatistics());
  }
//
  @Test
  void calculateAdvStatisticsZeroComments() {
    // Given
    Statistics statisticsMock = mock(Statistics.class);
    ForumStatistics forumStatistics = new ForumStatistics();
    List<String> usersNamesList = generateUserName(50);

    when(statisticsMock.userNames()).thenReturn(usersNamesList);
    when(statisticsMock.postCount()).thenReturn(1000);
    when(statisticsMock.commentCount()).thenReturn(0);

    // When
    forumStatistics.calculateAdvStatistics(statisticsMock);

    // Then
    String expectedMessage = "Posts per user: 20\nComments per user: 0\nComments per post: 0\n";
//    assertEquals(20, forumStatistics.getAveragePostsPerUser());
//    assertEquals(0, forumStatistics.getAverageCommentsPerUser());
//    assertEquals(0, forumStatistics.getAverageCommentsPerPost());
//    assertEquals(expectedMessage, forumStatistics.showStatistics());
  }

  @Test
  void calculateAdvStatisticsCommentsLessThanPosts() {
    // Given
    Statistics statisticsMock = mock(Statistics.class);
    ForumStatistics forumStatistics = new ForumStatistics();
    List<String> usersNamesList = generateUserName(150);

    when(statisticsMock.userNames()).thenReturn(usersNamesList);
    when(statisticsMock.postCount()).thenReturn(1000);
    when(statisticsMock.commentCount()).thenReturn(444);

    // When
    forumStatistics.calculateAdvStatistics(statisticsMock);

    // Then
    String expectedMessage = "Posts per user: 6\nComments per user: 2\nComments per post: 0\n";
//    assertEquals(6.666666666666667, forumStatistics.getAveragePostsPerUser());
//    assertEquals(2, forumStatistics.getAverageCommentsPerUser());
//    assertEquals(0, forumStatistics.getAverageCommentsPerPost());
//    assertEquals(expectedMessage, forumStatistics.showStatistics());
  }

  @Test
  void calculateAdvStatisticsCommentsMoreThanPosts() {
    // Given
    Statistics statisticsMock = mock(Statistics.class);
    ForumStatistics forumStatistics = new ForumStatistics();
    List<String> usersNamesList = generateUserName(150);

    when(statisticsMock.userNames()).thenReturn(usersNamesList);
    when(statisticsMock.postCount()).thenReturn(1000);
    when(statisticsMock.commentCount()).thenReturn(5444);

    // When
    forumStatistics.calculateAdvStatistics(statisticsMock);

    // Then
    String expectedMessage = "Posts per user: 6\nComments per user: 36\nComments per post: 5\n";
//    assertEquals(6, forumStatistics.getAveragePostsPerUser());
//    assertEquals(36, forumStatistics.getAverageCommentsPerUser());
//    assertEquals(5, forumStatistics.getAverageCommentsPerPost());
//    assertEquals(expectedMessage, forumStatistics.showStatistics());
  }

  @Test
  void calculateAdvStatisticsZeroUsers() {
    // Given
    Statistics statisticsMock = mock(Statistics.class);
    ForumStatistics forumStatistics = new ForumStatistics();
    List<String> usersNamesList = new ArrayList<>();

    when(statisticsMock.userNames()).thenReturn(usersNamesList);
    when(statisticsMock.postCount()).thenReturn(1000);
    when(statisticsMock.commentCount()).thenReturn(5444);

    // When
    forumStatistics.calculateAdvStatistics(statisticsMock);

    // Then
    String expectedMessage = "Posts per user: 0\nComments per user: 0\nComments per post: 5\n";
    assertEquals(0, forumStatistics.getAveragePostsPerUser());
    assertEquals(0, forumStatistics.getAverageCommentsPerUser());
    assertEquals(5, forumStatistics.getAverageCommentsPerPost());
//    assertEquals(expectedMessage, forumStatistics.showStatistics());
  }

  @Test
  void calculateAdvStatisticsHundredUsers() {
    // Given
    Statistics statisticsMock = mock(Statistics.class);
    ForumStatistics forumStatistics = new ForumStatistics();
    List<String> usersNamesList = generateUserName(100);

    when(statisticsMock.userNames()).thenReturn(usersNamesList);
    when(statisticsMock.postCount()).thenReturn(1000);
    when(statisticsMock.commentCount()).thenReturn(2000);

    // When
    forumStatistics.calculateAdvStatistics(statisticsMock);

    System.out.println((10.1 % 1) == 0);

    // Then
//    String expectedMessage = "Posts per user: 10\nComments per user: 20\nComments per post: 2\n";
//    assertEquals(10, forumStatistics.getAveragePostsPerUser());
//    assertEquals(20, forumStatistics.getAverageCommentsPerUser());
//    assertEquals(2, forumStatistics.getAverageCommentsPerPost());
//    assertEquals(expectedMessage, forumStatistics.showStatistics());
  }
}
