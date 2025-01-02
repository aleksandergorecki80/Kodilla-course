package com.kodilla.patterns2.dekorator.pizza;

import com.kodilla.patterns2.decorator.pizza.BasicPizzaOrder;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;
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
        assertEquals(new BigDecimal(15), cost);
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
}
