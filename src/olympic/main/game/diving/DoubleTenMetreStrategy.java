package olympic.main.game.diving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 策略模式下双人十米台规则
 */
public class DoubleTenMetreStrategy implements Strategy{
    private final ArrayList<Double> scores;
    private final int cycleNumber;

    DoubleTenMetreStrategy(){
        scores = new ArrayList<Double>();
        cycleNumber = 5;
    }

    /**
     * 通过当前策略来决定分数的算法
     * @return score 返回算出的分数
     */
    @Override
    public double decideScore(){
        Random r = new Random();
        double score=0.0;
        for(int i=0;i<3;i++){
            scores.add(r.nextInt(20)*0.5);
        }
        Collections.sort(scores);
        score+=scores.get(1);
        scores.clear();
        for(int i=0;i<3;i++){
            scores.add(r.nextInt(20)*0.5);
        }
        Collections.sort(scores);
        score+=scores.get(1);
        scores.clear();
        for(int i=0;i<5;i++){
            scores.add(r.nextInt(20)*0.5);
        }
        Collections.sort(scores);
        score+=scores.get(1) + scores.get(2) +scores.get(3);
        scores.clear();
        double difficulty =r.nextInt(40)/10.0;
        score= score / 5 * 3 * difficulty;
        scores.clear();
        return score;
    }

    @Override
    public int getCycleNumber(){
        return this.cycleNumber;
    }
}
