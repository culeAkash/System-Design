package LLD.FactoryPattern;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape(Shapes.Circle);

        circle.draw();
    }
}
