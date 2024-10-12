package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {
  @Test
  void testDefaultSharingStrategies() {
    // Given
    User millenial = new Millenials("Ethan Cooper");
    User yGenaration = new YGeneration("Olivia Mae Harrington");
    User zGeneration = new ZGeneration("Liam Parker");

    // When
    String millenialShare = millenial.sharePost();
    System.out.println(millenialShare);

    String yGenarationShare = yGenaration.sharePost();
    System.out.println(yGenarationShare);

    String zGenerationShare = zGeneration.sharePost();
    System.out.println(zGenerationShare);

    // Then
    assertEquals("Facebook", millenialShare);
    assertEquals("Snapchat", yGenarationShare);
    assertEquals("Twitter", zGenerationShare);
  }

  @Test
  void testIndividualSharingStrategy() {
    // Given
    User millenial = new Millenials("Ethan Cooper");

    // When
    String millenialShare = millenial.sharePost();
    System.out.println("Regular millenial's social media: " + millenialShare);
    millenial.setPublisher(new TwitterPublisher());
    millenialShare = millenial.sharePost();
    System.out.println("New millenial's social media: " + millenialShare);

    // Then
    assertEquals("Twitter", millenialShare);
  }
}
