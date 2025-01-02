package com.kodilla.patterns2.dekorator.pizza;

import com.kodilla.patterns2.decorator.pizza.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTests {

    @Test
    public void testBasicPizzaOrderCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(20), cost);
    }

    @Test
    public void testBasicPizzaOrderIngredients() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        // When
        String ingredients = pizzaOrder.getIngredients();

        // Then
        assertEquals("Ingredients: base, tomato sauce, cheese", ingredients);
    }

    @Test
    public void testPizzaWithOneExtraCheeseGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new CheeseOrderDecorator(pizzaOrder);

        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(25), cost);
    }

    @Test
    public void testPizzaWithOneExtraCheeseGetIngredients() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new CheeseOrderDecorator(pizzaOrder);

        // When
        String ingredients = pizzaOrder.getIngredients();

        // Then
        assertEquals("Ingredients: base, tomato sauce, cheese + extra cheese", ingredients);
    }


    @Test
    public void testBasicPizzaWithPineappleCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PineappleOrderDecorator(pizzaOrder);

        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(27), cost);
    }

    @Test
    public void testBasicPizzaWithPineappleIngredients() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PineappleOrderDecorator(pizzaOrder);

        // When
        String ingredients = pizzaOrder.getIngredients();

        // Then
        assertEquals("Ingredients: base, tomato sauce, cheese + pineapple", ingredients);
    }

    @Test
    public void testBasicPizzaWithPineappleAndChickenCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PineappleOrderDecorator(pizzaOrder);
        pizzaOrder = new ChickenOrderDecorator(pizzaOrder);

        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(35), cost);
    }

    @Test
    public void testBasicPizzaWithPineappleAndChickenIngredients() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PineappleOrderDecorator(pizzaOrder);
        pizzaOrder = new ChickenOrderDecorator(pizzaOrder);

        // When
        String ingredients = pizzaOrder.getIngredients();

        // Then
        assertEquals("Ingredients: base, tomato sauce, cheese + pineapple + chicken", ingredients);
    }

    @Test
    public void testBasicPizzaWithPineappleChickenAndHamCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PineappleOrderDecorator(pizzaOrder);
        pizzaOrder = new ChickenOrderDecorator(pizzaOrder);
        pizzaOrder = new HamOrderDecorator(pizzaOrder);

        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(44), cost);
    }

    @Test
    public void testBasicPizzaWithPineappleChickenAndHamIngredients() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PineappleOrderDecorator(pizzaOrder);
        pizzaOrder = new ChickenOrderDecorator(pizzaOrder);
        pizzaOrder = new HamOrderDecorator(pizzaOrder);

        // When
        String ingredients = pizzaOrder.getIngredients();

        // Then
        assertEquals("Ingredients: base, tomato sauce, cheese + pineapple + chicken + ham", ingredients);
    }

    @Test
    public void testBasicPizzaWithTofuAndDoubleCheeseCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new TofuOrderDecorator(pizzaOrder);
        pizzaOrder = new CheeseOrderDecorator(pizzaOrder);
        pizzaOrder = new CheeseOrderDecorator(pizzaOrder);

        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(42), cost);
    }

    @Test
    public void testBasicPizzaWithTofuAndDoubleCheeseIngredients() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new TofuOrderDecorator(pizzaOrder);
        pizzaOrder = new CheeseOrderDecorator(pizzaOrder);
        pizzaOrder = new CheeseOrderDecorator(pizzaOrder);

        // When
        String ingredients = pizzaOrder.getIngredients();

        // Then
        assertEquals("Ingredients: base, tomato sauce, cheese + tofu + extra cheese + extra cheese", ingredients);
    }
}
