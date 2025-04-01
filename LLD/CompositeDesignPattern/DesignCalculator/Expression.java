package LLD.CompositeDesignPattern.DesignCalculator;

public class Expression implements ArithmeticExpression {
    private ArithmeticExpression lefArithmeticExpression;
    private ArithmeticExpression rightArithmeticExpression;
    private ArithmeticOperator operator;

    public Expression(ArithmeticExpression lefArithmeticExpression, ArithmeticExpression rightArithmeticExpression, ArithmeticOperator operator) {
        this.lefArithmeticExpression = lefArithmeticExpression;
        this.rightArithmeticExpression = rightArithmeticExpression;
        this.operator = operator;
    }

    @Override
    public int evaluate() {
        int value = 0;
        switch (operator) {
            case ADD:
                value = lefArithmeticExpression.evaluate() + rightArithmeticExpression.evaluate();
                break;
            case SUBTRACT:
                value = lefArithmeticExpression.evaluate() - rightArithmeticExpression.evaluate();
                break;
            case MULTIPLY:
                value = lefArithmeticExpression.evaluate() * rightArithmeticExpression.evaluate();
                break;
            case DIVIDE:
                value = lefArithmeticExpression.evaluate() / rightArithmeticExpression.evaluate();
                break;
            default:
                break;
        }
        return value;
    }
}
