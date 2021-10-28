package olympic.main.game.diving;

public class FinalContest implements Contest{

    private Contest nextContest = null;
    private AthletePool athletePool = null;

//    @Override
//    public void process(AthletePool athletePool){
//        for (int i = 1; i <= athletePool.getStrategy().getCycleNumber(); i++) {
//            System.out.println("第" + i + "轮比赛开始！");
//            for (int j = 0; j < athletePool.getSize(); j++) {
//                Athlete curAthlete = athletePool.appear();
//                double score = athletePool.getStrategy().decideScore();
//                System.out.println(curAthlete.getName() + "的第" + i + "轮分数为" + String.format("%.3f", score));
//                curAthlete.addScore(score);
//                athletePool.disappear();
//            }
//            System.out.println("第" + i + "轮结束。");
//        }
//    }

    @Override
    public void takePlace(AthletePool athletePool) {
        this.athletePool=athletePool;
        start();
//        System.out.println("决赛正式开始！");
//        process(athletePool);
//        System.out.println("决赛结束，最终比分如下:");
//        athletePool.sort("决赛");
//        System.out.println("让我们恭喜最后获奖的运动员！");
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
                Athlete curAthlete = athletePool.appear();
                double score = athletePool.getStrategy().decideScore();
                System.out.println(curAthlete.getName() + "的第" + i + "轮分数为" + String.format("%.3f", score));
                curAthlete.addScore(score);
                athletePool.disappear();
            }
            System.out.println("第" + i + "轮结束。");
        }
        System.out.println("决赛结束，最终比分如下:");
        athletePool.sort("决赛");
        System.out.println("让我们恭喜最后获奖的运动员！");
    }

    @Override
    public void setNext(Contest contest){
        this.nextContest=contest;
    }
}
