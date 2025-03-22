package LLD.DecoratorPattern.PizzaExample.PizzaDecorators;

import LLD.DecoratorPattern.PizzaExample.PizzaBase.BasePizza;

public class ExtraCheesePizzaDecorator extends PizzaDecorator {
    private final BasePizza basePizza;


    public ExtraCheesePizzaDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
    
}
