package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
  private final BunType bun;
  private final int burgers;
  private final String sauce;
  private final List<String> ingredients;

  private Bigmac(final BunType bun, final int burgers, final String sauce, final List<String> ingredients) {
    this.bun = bun;
    this.burgers = burgers;
    this.sauce = sauce;
    this.ingredients = new ArrayList<>(ingredients);
  }

  public BunType getBun() {
    return bun;
  }

  public int getBurgers() {
    return burgers;
  }

  public String getSauce() {
    return sauce;
  }

  public List<String> getIngredients() {
    return ingredients;
  }

  @Override
  public String toString() {
    return "Burger: " + burgers + ", Sauce: " + sauce + ", Ingredients: " + ingredients;
  }

  public static class BigmacBuilder {
    private BunType bun;
    private int burgers;
    private String sauce;
    private final List<String> ingredients = new ArrayList<>();

    public BigmacBuilder bun(BunType bun) {
      this.bun = bun;
      return this;
    }

    public BigmacBuilder burgers(int burgers) {
      this.burgers = burgers;
      return this;
    }

    public BigmacBuilder sauce(String sauce) {
      this.sauce = sauce;
      return this;
    }

    public BigmacBuilder ingredient(String ingredient) {
      this.ingredients.add(ingredient);
      return this;
    }

    public Bigmac build() {
      return new Bigmac(bun, burgers, sauce, ingredients);
    }
  }
}
