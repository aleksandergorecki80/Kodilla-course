package com.kodilla.patterns.strategy.social;

public interface SocialPublisher {
public sealed interface SocialPublisher
  permits SnapchatPublisher, TwitterPublisher, FacebookPublisher{
  String share();
}
