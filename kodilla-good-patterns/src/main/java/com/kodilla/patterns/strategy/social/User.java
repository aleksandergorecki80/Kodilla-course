package com.kodilla.patterns.strategy.social;

public class User {
  private final String name;
  protected SocialPublisher publisher;

  public User(final String name) {
    this.name = name;
  }

  public String sharePost() {
    return publisher.share();
  }

  public void setPublisher(SocialPublisher publisher) {
    this.publisher = publisher;
  }
}