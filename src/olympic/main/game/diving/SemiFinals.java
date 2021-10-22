package olympic.main.game.diving;

import java.util.Random;

public class SemiFinals implements Contest{

    private Contest nextContest;

    public void process(AthletePool athletePool){
        for (int i = 1; i < 7; i++) {
            System.out.println("第" + i + "轮比赛开始！");
            for (int j = 0; j < athletePool.getSize(); j++) {
                Athlete curAthlete = athletePool.appear();
                double score = athletePool.getStrategy().decideScore();;
                System.out.println(curAthlete.getName() + "的第" + i + "轮分数为" + String.format("%.3f", score));
                curAthlete.addScore(score);
                athletePool.disappear();
            }
            System.out.println("第" + i + "轮结束。");
        }
    }

    public void takePlace(AthletePool athletePool) {
        System.out.println("半决赛正式开始！");
        process(athletePool);
        System.out.println("半决赛结束，最终比分如下:");
        athletePool.sort("半决赛");
        athletePool.eliminate(12);
        System.out.println("让我们恭喜前12位选手进入下一轮！");
        if (this.nextContest != null) {
            this.nextContest.takePlace(athletePool);
        }
    }

    public void setNext(Contest contest){
        this.nextContest=contest;
    }
}
