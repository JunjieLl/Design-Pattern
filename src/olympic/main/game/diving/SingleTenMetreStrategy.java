package olympic.main.game.diving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SingleTenMetreStrategy implements Strategy{//6
    public ArrayList<Double> scores;
    private final int cycleNumber;

    SingleTenMetreStrategy(){
        scores = new ArrayList<Double>();
        cycleNumber = 6;
    }

    public double decideScore(){
        Random r = new Random();
        for(int i=0;i<7;i++){
            scores.add(r.nextInt(20)*0.5);
        }
        double difficulty =r.nextInt(40)/10.0;
        Collections.sort(scores);
        double score= (scores.get(2) + scores.get(3) +scores.get(4)) * difficulty;
        scores.clear();
        return score;
    }

    public int getCycleNumber(){
        return this.cycleNumber;
    }
}
