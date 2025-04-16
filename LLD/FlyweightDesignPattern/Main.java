package LLD.FlyweightDesignPattern;

import LLD.FlyweightDesignPattern.robot.IRobot;
import LLD.FlyweightDesignPattern.robot.RobotType;

public class Main {
    public static void main(String[] args) {
        IRobot humanoid1 = RoboticCache.createRobot(RobotType.HUMANOID);
        humanoid1.display(10, 20);

        IRobot  dogRobot1 = RoboticCache.createRobot(RobotType.DOG_ROBOT);
        dogRobot1.display(10, 20);

        IRobot humanoid2 = RoboticCache.createRobot(RobotType.HUMANOID);
        humanoid2.display(10, 20);

        System.out.println(humanoid1 == humanoid2);
    }
}
