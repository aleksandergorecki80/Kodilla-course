package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PineappleOrderDecorator extends AbstractPizzaOrderDecorator {

    public PineappleOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(7));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + pineapple";
    }
}
