package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ChickenOrderDecorator extends AbstractPizzaOrderDecorator{
    public ChickenOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(8));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + chicken";
    }
}
