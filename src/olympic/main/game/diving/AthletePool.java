package olympic.main.game.diving;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import olympic.main.person.athlete.Athlete;

import java.util.*;

public class AthletePool {
    private final LinkedList<Athlete> pool;
    private final Strategy strategy;
    private final Map<Athlete, Double> allScore = new HashMap<>();
    private List<Map.Entry<Athlete, Double>> list;

    public AthletePool(Strategy strategy, LinkedList<Athlete> athleteList) {
        this.pool = athleteList;
        for (Athlete athlete : pool) {
            this.allScore.put(athlete, 0.0);
        }
        this.strategy = strategy;
    }

    public int getSize() {
        return this.pool.size();
    }

    public void add(Athlete object) {
        this.pool.add(object);
    }

    public void addScore(Athlete object , double score) {
        this.allScore.put(object,this.allScore.get(object) + score);
    }

    public Athlete appear() {
        return this.pool.getFirst();
    }

    public void disappear() {
        Athlete object = this.pool.poll();
        this.pool.add(object);
    }

    public Strategy getStrategy(){
        return this.strategy;
    }

    public void getResult(String game) {
        list = new ArrayList<Map.Entry<Athlete, Double>>(allScore.entrySet());
        list.sort(new Comparator<Entry<Athlete, Double>>() {
            //降序排序
            @Override
            public int compare(Entry<Athlete, Double> o1, Entry<Athlete, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(int i=0;i< list.size();i++){
            System.out.printf(" 第%d名 %s : %.3f\n", i + 1, list.get(i).getKey().getName(), list.get(i).getValue());
            list.get(i).getKey().setRank(game, i+1);
        }
    }

    public void eliminate(int num) {
        pool.clear();
        allScore.clear();
        while (num > 0) {
            pool.add(list.get(num-1).getKey());
            allScore.put(list.get(num-1).getKey(),0.0);
            num--;
        }
        list.clear();
    }
}
