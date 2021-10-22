package olympic.main.game.diving;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class AthletePool {
    private final LinkedList<Athlete> pool;

    public AthletePool() {
        this.pool = new LinkedList<>();
    }

    public int getSize() {
        return this.pool.size();
    }

    public void add(Athlete object) {
        this.pool.add(object);
    }

    public Athlete appear() {
        return this.pool.getFirst();
    }

    public void disappear() {
        Athlete object = this.pool.poll();
        this.pool.add(object);
    }

    public void sort(String game) {
        Collections.sort(pool);
        for (int i = 0; i < pool.size(); i++) {
            Athlete curAthlete = pool.get(i);
            double score = pool.get(i).getCurScore();
            System.out.printf(" 第%d名 %s : %.2f\n", i + 1, curAthlete.getName(), score);
            if (Objects.equals(game, "预赛")) {
                curAthlete.setPreliminaryScore(score);
            } else if (Objects.equals(game, "半决赛")) {
                curAthlete.setSemiFinalScore(score);
            } else if (Objects.equals(game, "决赛")) {
                curAthlete.setFinalScore(score);
            }
            curAthlete.clearCurScore();
        }
    }

    public void eliminate(int num){
        while(pool.size()>num){
            pool.pollLast();
        }
    }
}
