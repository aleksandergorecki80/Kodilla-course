package com.kodilla.stream.beautifier;

public class PoemBeautifier {

  public String beautify(String text, PoemDecorator decorator) {
    return decorator.decorate(text);
  }
}
