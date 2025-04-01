package LLD.CompositeDesignPattern.DesignCalculator;

public class Main {
    public static void main(String[] args) {
        // solve for 2 + (3 * 7)


        // first create 3 * 7
        ArithmeticExpression threeTimesSeven = new Expression(new Number(3), new Number(7),ArithmeticOperator.MULTIPLY);
        // then create 2 + (3 * 7)
        ArithmeticExpression twoPlusThreeTimesSeven = new Expression(new Number(2), threeTimesSeven,ArithmeticOperator.ADD);

        System.out.println(twoPlusThreeTimesSeven.evaluate());
    }
}
