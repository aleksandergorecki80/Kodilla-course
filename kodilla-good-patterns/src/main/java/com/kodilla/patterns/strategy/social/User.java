package com.kodilla.patterns.strategy.social;

public class User {
public sealed class User permits Millenials, ZGeneration, YGeneration {
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
