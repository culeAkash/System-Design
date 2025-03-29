package LLD.SnakeNLadderLowLevelDesign;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int count;
    int min;
    int max;

    public Dice(int count){
        this.count = 1;
        min = 1;
        max = 6;
    }


    public int rollDice(){
        int finalResult = 0;
        int noOfDice = count;
        while(noOfDice-- > 0){
            int rollResult = (ThreadLocalRandom.current().nextInt(min, max + 1));
            System.out.println("Dice rolled: " + rollResult);
            finalResult += rollResult;
        }
        return finalResult;
    }
}
