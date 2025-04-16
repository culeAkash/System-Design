package LLD.FlyweightDesignPattern.robot;

import LLD.FlyweightDesignPattern.Stripes;

public class DogRobot implements IRobot{ 
    private RobotType robotType;
    private Stripes stripes;

    public DogRobot(RobotType robotType, Stripes stripes) {
        this.robotType = robotType;
        this.stripes = stripes;
    }

    public RobotType getRobotType() {
        return robotType;
    }

    public Stripes getStripes() {
        return stripes;
    }

    @Override
    public void display(int x, int y) {
        // use the dog robot sprites object
        // and the X and Y coordinates to render the image
        System.out.println("Displaying dog robot at (" + x + ", " + y + ")");
    }
    
}
