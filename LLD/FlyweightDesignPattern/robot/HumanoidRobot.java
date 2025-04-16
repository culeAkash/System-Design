package LLD.FlyweightDesignPattern.robot;

import LLD.FlyweightDesignPattern.Stripes;

public class HumanoidRobot implements IRobot {
    private RobotType robotType;
    private Stripes stripes;

    public HumanoidRobot(RobotType robotType, Stripes stripes) {
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
        // use the humanoid sprites object
        // and the X and Y coordinates to render the image
        System.out.println("Displaying humanoid robot at (" + x + ", " + y + ")");
    }
}
