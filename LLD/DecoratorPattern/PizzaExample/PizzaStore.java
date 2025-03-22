package LLD.DecoratorPattern.PizzaExample;

import LLD.DecoratorPattern.PizzaExample.PizzaBase.BasePizza;
import LLD.DecoratorPattern.PizzaExample.PizzaBase.MargheritaBasePizza;
import LLD.DecoratorPattern.PizzaExample.PizzaDecorators.ExtraCheesePizzaDecorator;
import LLD.DecoratorPattern.PizzaExample.PizzaDecorators.MushroomPizzaDecorator;

public class PizzaStore {
    public static void main(String[] args) {
        BasePizza basePizza = new MargheritaBasePizza();
        BasePizza pizzaWithMushroom = new MushroomPizzaDecorator(basePizza);
        BasePizza pizzaWithMushroomAndCheese = new ExtraCheesePizzaDecorator(pizzaWithMushroom);

        System.out.println(pizzaWithMushroomAndCheese.cost());
    }
}
