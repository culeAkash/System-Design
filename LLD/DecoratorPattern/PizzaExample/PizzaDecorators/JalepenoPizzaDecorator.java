package LLD.DecoratorPattern.PizzaExample.PizzaDecorators;

import LLD.DecoratorPattern.PizzaExample.PizzaBase.BasePizza;

public class JalepenoPizzaDecorator extends PizzaDecorator{
    private final BasePizza basePizza;


    public JalepenoPizzaDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 5;
    }
    
}
