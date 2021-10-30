package olympic.main.game.diving;

import olympic.main.person.athlete.Athlete;

public class FinalContest extends DivingGame {

    private DivingGame nextContest = null;
    private AthletePool athletePool = null;


    public void takePlace(AthletePool athletePool) {
        this.athletePool=athletePool;
        start();
        if (this.nextContest != null) {
            this.nextContest.takePlace(this.athletePool);
        }
    }

    @Override
    public void start(){
        System.out.println("决赛正式开始！");
        for (int i = 1; i <= athletePool.getStrategy().getCycleNumber(); i++) {
            System.out.println("第" + i + "轮比赛开始！");
            for (int j = 0; j < athletePool.getSize(); j++) {
                Athlete curDivingAthlete = athletePool.appear();
                double score = athletePool.getStrategy().decideScore();
                System.out.println(curDivingAthlete.getName() + "的第" + i + "轮分数为" + String.format("%.3f", score));
                athletePool.addScore(curDivingAthlete,score);
                athletePool.disappear();
            }
            System.out.println("第" + i + "轮结束。");
        }
        System.out.println("决赛结束，最终比分如下:");
        athletePool.getResult("决赛");
        System.out.println("让我们恭喜最后获奖的运动员！");
    }


    public void setNext(DivingGame contest){
        this.nextContest=contest;
    }
}
