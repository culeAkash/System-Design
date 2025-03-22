package LLD.DecoratorPattern.MealCalorieCounterExample.MealDecorators;

import LLD.DecoratorPattern.MealCalorieCounterExample.MealBase.BaseMeal;

public class BreadMealDecorator extends MealDecorator {
    private final BaseMeal baseMeal;

    public BreadMealDecorator(BaseMeal baseMeal) {
        this.baseMeal = baseMeal;
    }

    @Override
    public int getCalories() {
        return this.baseMeal.getCalories() + 15;
    }
}
