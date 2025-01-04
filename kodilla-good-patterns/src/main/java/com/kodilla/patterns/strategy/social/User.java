package com.kodilla.patterns.strategy.social;

public sealed class User permits Millenials, YGeneration, ZGeneration {
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
