package olympic.main.game.diving;

import java.util.Random;

public class PreliminaryContest implements Contest {

    private Contest nextContest;

    public void process(AthletePool athletePool ,Random r){
        for (int i = 0; i < 6; i++) {
            System.out.println("第" + i + "轮比赛开始！");
            for (int j = 0; j < athletePool.getSize(); j++) {
                Athlete curAthlete = athletePool.appear();
                int score = r.nextInt(10000);
                System.out.println(curAthlete.getName() + "的第" + i + "轮分数为" + (double)score/10);
                curAthlete.addScore((double)score/10);
                athletePool.disappear();
            }
            System.out.println("第" + i + "轮结束。");
        }
    }

    public void takePlace(AthletePool athletePool) {
        System.out.println("预赛正式开始！");
        Random r = new Random(3);
        process(athletePool,r);
        System.out.println("预赛结束，最终比分如下:");
        athletePool.sort("预赛");
        athletePool.eliminate(18);
        System.out.println("让我们恭喜前18位选手进入下一轮！");
        if (this.nextContest != null) {
            this.nextContest.takePlace(athletePool);
        }
    }

    public void setNext(Contest contest){
        this.nextContest=contest;
    }
}
