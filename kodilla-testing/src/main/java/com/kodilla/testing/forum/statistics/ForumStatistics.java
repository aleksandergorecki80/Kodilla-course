package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
  private int usersCount;
  private int postsCount;
  private int commentsCount;
  private double averagePostsPerUser;
  private double averageCommentsPerUser;
  private double averageCommentsPerPost;

  public void calculateAdvStatistics(Statistics statistics){
     this.usersCount = statistics.userNames().size();
     this.postsCount = statistics.postCount();
     this.commentsCount = statistics.commentCount();
     this.averagePostsPerUser = roundToTwoDigits(calculateAveragePostsPerUser());
     this.averageCommentsPerUser = roundToTwoDigits(calculateAverageCommentsPerUser());
     this.averageCommentsPerPost = roundToTwoDigits(calculateAverageCommentsPerPost());
  }

  private double roundToTwoDigits(double number){
   return Math.round(number * 100.0) / 100.0;
  }

  private double calculateAveragePostsPerUser() {
    if (this.usersCount == 0) return 0;
    return  this.postsCount / (double) this.usersCount;
  }

  private double calculateAverageCommentsPerUser() {
    if (this.usersCount == 0) return 0;
    return this.commentsCount / (double) this.usersCount;
  }

  private double calculateAverageCommentsPerPost() {
    if (this.postsCount == 0) return 0;
    return this.commentsCount / (double) this.postsCount;
  }

  public double getAveragePostsPerUser() {
    return averagePostsPerUser;
  }

  public double getAverageCommentsPerUser() {
    return averageCommentsPerUser;
  }

  public double getAverageCommentsPerPost() {
    return averageCommentsPerPost;
  }

  private String formatAverageValue(double value){
    String result = "";
    if ( value % 1 == 0) {
      result = String.format("%.0f", value);
    } else {
      result = String.format("%.2f", value);
    }
    return result;
  }

  public String showStatistics() {
    String separator = "\n";
    String averagePostsCountPerUserMessage;
    String averageCommentsCountPerUserMessage;
    String averageCommentsCountPerPostMessage;

    if (this.usersCount == 0) {
      averagePostsCountPerUserMessage = "No users found" + separator;
      averageCommentsCountPerUserMessage = "No users found" + separator;
    } else {
      averagePostsCountPerUserMessage = "Posts per user: " + formatAverageValue(averagePostsPerUser) + separator;
      averageCommentsCountPerUserMessage = "Comments per user: " + formatAverageValue(averageCommentsPerUser) + separator;
    }

    if (this.postsCount == 0) {
      averageCommentsCountPerPostMessage = "No posts found" + separator;
    } else {
      averageCommentsCountPerPostMessage = "Comments per post: " + formatAverageValue(averageCommentsPerPost) + separator;
    }



    return this.usersCount == 0
              ? "No user found" + separator + averageCommentsCountPerPostMessage
              : averagePostsCountPerUserMessage + averageCommentsCountPerUserMessage + averageCommentsCountPerPostMessage;
  }


}
