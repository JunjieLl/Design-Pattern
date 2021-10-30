package olympic.main.game.diving;

import olympic.main.person.athlete.Athlete;

public class SemiFinals extends DivingGame {

    private DivingGame nextDivingGame;
    private AthletePool athletePool = null;

    public void takePlace(AthletePool athletePool) {
        this.athletePool=athletePool;
        start();
        if (this.nextDivingGame != null) {
            this.nextDivingGame.takePlace(athletePool);
        }
    }

    @Override
    public void start(){
        System.out.println("半决赛正式开始！");
        for (int i = 1; i <= athletePool.getStrategy().getCycleNumber(); i++) {
            System.out.println("第" + i + "轮比赛开始！");
            for (int j = 0; j < athletePool.getSize(); j++) {
                Athlete curDivingAthlete = athletePool.appear();
                double score = athletePool.getStrategy().decideScore();;
                System.out.println(curDivingAthlete.getName() + "的第" + i + "轮分数为" + String.format("%.3f", score));
                athletePool.addScore(curDivingAthlete,score);
                athletePool.disappear();
            }
            System.out.println("第" + i + "轮结束。");
        }
        System.out.println("半决赛结束，最终比分如下:");
        athletePool.getResult("半决赛");
        athletePool.eliminate(12);
        System.out.println("让我们恭喜前12位选手进入下一轮！");
    }

    @Override
    public void setNext(DivingGame divingGame){
        this.nextDivingGame = divingGame;
    }
}
