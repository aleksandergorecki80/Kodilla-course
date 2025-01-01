package com.kodilla.patterns.strategy.social;

public sealed interface SocialPublisher
  permits SnapchatPublisher, TwitterPublisher, FacebookPublisher{
  String share();
}
