package olympic.main.game.diving;

import olympic.Utils.PrintBlockFormat;
import olympic.main.director.Mode;
import olympic.main.game.Valve;
import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

/**
 * 跳水初赛
 */
public class PreliminaryContest extends DivingGame {

    /**
     * 管道模式中下一轮比赛
     */
    private DivingGame nextDivingGame;

    /**
     * 参赛运动员组成的对象池
     */
    private AthletePool athletePool;

    /**
     * 获取管道模式中上一轮比赛的结果
     *
     * @param athletePool 包含该轮比赛人员的对象池
     */
    public void takePlace(AthletePool athletePool) {
        this.athletePool = athletePool;
        start();
        if (this.nextDivingGame != null) {
            this.nextDivingGame.takePlace(athletePool);
        }
    }

    /**
     * 开始本轮比赛
     */
    @Override
    public void start() {
        System.out.println("\nclassname: (PreliminaryContest) method: (start) action: (管道模式下开始预赛) ");
        System.out.println("【" + athletePool.getStrategy().getName() + " 预赛】");
        for (int i = 1; i <= athletePool.getStrategy().getCycleNumber(); i++) {
            List<String> ceremonyInitPrintBlock = new ArrayList<>();
            ceremonyInitPrintBlock.add("第" + i + "轮");
            for (int j = 0; j < athletePool.getSize(); j++) {
                Athlete curDivingAthlete = athletePool.appear();
                double score = athletePool.getStrategy().decideScore();
                if (athletePool.getDetail()) {
                    ceremonyInitPrintBlock.add(String.format("来自\t%-3s\t的%-15s\t" + "第" + i + "轮分数为\t" + "%.3f", curDivingAthlete.getNation(), curDivingAthlete.getName(), score));
                }
                athletePool.addScore(curDivingAthlete, score);
                athletePool.disappear();
            }
            ceremonyInitPrintBlock.add("第" + i + "轮结束\n");
            PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
            printBlockFormat.printFormatLeftScreen(ceremonyInitPrintBlock, Mode.getShowDetail());
        }
        athletePool.getResult("预赛");
        athletePool.eliminate(18);
        System.out.println("让我们恭喜前18位选手进入下一轮！");
    }

    /**
     * 获取下一轮比赛
     *
     * @param divingGame 下一轮比赛
     */
    @Override
    public Valve setNext(Valve divingGame) {
        this.nextDivingGame = (DivingGame) divingGame;
        return null;
    }
}
