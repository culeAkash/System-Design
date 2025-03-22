package LLD.DecoratorPattern.MealCalorieCounterExample;

import LLD.DecoratorPattern.MealCalorieCounterExample.MealBase.BaseMeal;
import LLD.DecoratorPattern.MealCalorieCounterExample.MealBase.ChickenBaseMeal;
import LLD.DecoratorPattern.MealCalorieCounterExample.MealDecorators.RiceMealDecorator;

public class MealStore {
    public static void main(String[] args) {
        BaseMeal chickenMeal = new ChickenBaseMeal();

        BaseMeal chickenWithRiceMeal = new RiceMealDecorator(chickenMeal);

        System.out.println(chickenWithRiceMeal.getCalories());
    }
}
