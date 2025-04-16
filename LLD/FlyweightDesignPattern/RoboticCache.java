package LLD.FlyweightDesignPattern;

import java.util.HashMap;
import java.util.Map;

import LLD.FlyweightDesignPattern.robot.DogRobot;
import LLD.FlyweightDesignPattern.robot.HumanoidRobot;
import LLD.FlyweightDesignPattern.robot.IRobot;
import LLD.FlyweightDesignPattern.robot.RobotType;

public class RoboticCache {
    public static Map<RobotType,IRobot> roboticCache = new HashMap<>();

    public static IRobot createRobot(RobotType robotType) {
        if(roboticCache.containsKey(robotType)){
            return roboticCache.get(robotType);
        }
        else{
            Stripes stripes = new Stripes();
            IRobot robot = null;
            switch(robotType){
                case HUMANOID:
                    robot = new HumanoidRobot(robotType, stripes);
                    break;
                case DOG_ROBOT:
                    robot = new DogRobot(robotType, stripes);
                    break;
                default:
                    break;
            }
            roboticCache.put(robotType, robot);
            return robot;
        }
    }
}
