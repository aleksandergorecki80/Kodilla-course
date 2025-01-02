package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class TofuOrderDecorator extends AbstractPizzaOrderDecorator{
    public TofuOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(12));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + tofu";
    }
}
