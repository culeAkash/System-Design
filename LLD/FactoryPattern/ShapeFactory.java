package LLD.FactoryPattern;

public class ShapeFactory {
    Shape getShape(Shapes shape){
        switch (shape){
            case Circle:
                return new Circle();
            case Square:
                return new Square();
            default:
                return new Rectangle();
        }
    }
}
