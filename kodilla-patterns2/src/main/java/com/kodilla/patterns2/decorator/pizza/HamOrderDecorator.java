package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamOrderDecorator extends AbstractPizzaOrderDecorator {
    public HamOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(9));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + ham";
    }
}
