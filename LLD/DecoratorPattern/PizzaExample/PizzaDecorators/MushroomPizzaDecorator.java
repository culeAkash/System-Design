package LLD.DecoratorPattern.PizzaExample.PizzaDecorators;

import LLD.DecoratorPattern.PizzaExample.PizzaBase.BasePizza;

public class MushroomPizzaDecorator extends PizzaDecorator {
    private final BasePizza basePizza;


    public MushroomPizzaDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 15;
    }
}
