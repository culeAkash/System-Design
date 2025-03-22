package LLD.DecoratorPattern.MealCalorieCounterExample.MealDecorators;

import LLD.DecoratorPattern.MealCalorieCounterExample.MealBase.BaseMeal;

public class RiceMealDecorator extends MealDecorator {
    private final BaseMeal baseMeal;

    public RiceMealDecorator(BaseMeal baseMeal) {
        this.baseMeal = baseMeal;
    }

    @Override
    public int getCalories() {
        return this.baseMeal.getCalories() + 20;
    }
}
