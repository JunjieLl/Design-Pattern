package olympic.main.game.diving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SingleThreeMetreStrategy implements Strategy{
    public ArrayList<Double> scores;

    SingleThreeMetreStrategy(){
        scores = new ArrayList<Double>();
    }

    public double decideScore(){
        Random r = new Random();
        for(int i=0;i<7;i++){
            scores.add(r.nextInt(20)*0.5);
        }
        double difficulty =r.nextInt(35)/10.0;
        Collections.sort(scores);
        double score= (scores.get(2) + scores.get(3) +scores.get(4)) * difficulty;
        scores.clear();
        return score;
    }
}
