package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
  private int usersCount;
  private int postsCount;
  private int commentsCount;
  private int averagePostsPerUser;
  private int averageCommentsPerUser;
  private int averageCommentsPerPost;

  public void calculateAdvStatistics(Statistics statistics){
     this.usersCount = statistics.userNames().size();
     this.postsCount = statistics.postCount();
     this.commentsCount = statistics.commentCount();
     this.averagePostsPerUser = this.calculateAveragePostsPerUser();
     this.averageCommentsPerUser = this.calculateAverageCommentsPerUser();
     this.averageCommentsPerPost = this.calculateAverageCommentsPerPost();
  }



//  Math.round(area * 100.0) / 100.0;

  private int calculateAveragePostsPerUser() {
    if (this.usersCount == 0 || this.usersCount > this.postsCount) return 0;
    return  this.postsCount / this.usersCount;
  }

  private int calculateAverageCommentsPerUser() {
    if (this.usersCount == 0 || this.usersCount > this.commentsCount) return 0;
    return  this.commentsCount / this.usersCount;
  }

  private int calculateAverageCommentsPerPost() {
    if (this.postsCount == 0 || this.postsCount > this.commentsCount) return 0;
    return this.commentsCount / this.postsCount;
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

  public String showStatistics() {
    String separator = "\n";
    String averagePostsCountPerUserMessage;
    String averageCommentsCountPerUserMessage;
    String averageCommentsCountPerPostMessage;

    if (this.usersCount == 0) {
      averagePostsCountPerUserMessage = "No users found" + separator;
      averageCommentsCountPerUserMessage = "No users found" + separator;
    } else {
      averagePostsCountPerUserMessage = "Posts per user: " + this.averagePostsPerUser + separator;
      averageCommentsCountPerUserMessage = "Comments per user: " + this.averageCommentsPerUser + separator;
    }

    if (this.postsCount == 0) {
      averageCommentsCountPerPostMessage = "No posts found" + separator;
    } else {
      averageCommentsCountPerPostMessage = "Comments per post: " + this.averageCommentsPerPost + separator;
    }



    return this.usersCount == 0
              ? "No user found" + separator + averageCommentsCountPerPostMessage
              : averagePostsCountPerUserMessage + averageCommentsCountPerUserMessage + averageCommentsCountPerPostMessage;
  }


}
