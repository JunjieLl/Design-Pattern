package olympic.main.game.diving;

import olympic.main.person.athlete.Athlete;
import olympic.scene.CeremonyScene;

/**
 * 跳水决赛
 */
public class FinalContest extends DivingGame {

    /**
     * 管道模式中下一轮比赛
     */
    private DivingGame nextContest = null;
    private AthletePool athletePool = null;


    /**
     *获取管道模式中上一轮比赛的结果
     * @param athletePool 包含该轮比赛人员的对象池
     */
    public void takePlace(AthletePool athletePool) {
        this.athletePool=athletePool;
        start();
        if (this.nextContest != null) {
            this.nextContest.takePlace(this.athletePool);
        }
    }

    /**
     * 开始本轮比赛
     */
    @Override
    public void start(){
        System.out.println("\nclassname: (FinalContest) method: (start) action: (管道模式下开始决赛) ");
        System.out.println("【"+athletePool.getStrategy().getName()+" 决赛】");
        for (int i = 1; i <= athletePool.getStrategy().getCycleNumber(); i++) {
            System.out.println("【第" + i + "轮】");
            for (int j = 0; j < athletePool.getSize(); j++) {
                Athlete curDivingAthlete = athletePool.appear();
                double score = athletePool.getStrategy().decideScore();
                if(athletePool.getDetail()) {
                    System.out.printf("来自\t%-19s\t的%-10s\t" + "第" + i + "轮分数为\t" + "%.3f\n", curDivingAthlete.getNation(), curDivingAthlete.getName(), score);
                }
                athletePool.addScore(curDivingAthlete,score);
                athletePool.disappear();
            }
            System.out.println("第" + i + "轮结束\n");
        }
        System.out.println("【决赛积分榜】");
        athletePool.getResult("决赛");
        System.out.println("让我们恭喜最后获奖的运动员！");
        new CeremonyScene(athletePool.gotoCeremony(3)).play();
    }

    /**
     * 获取下一轮比赛
     * @param contest 下一轮比赛
     */
    public void setNext(DivingGame contest){
        this.nextContest=contest;
    }
}
