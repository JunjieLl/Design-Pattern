package olympic.main.game.diving;

import olympic.main.drawlots.PaperDrawLotsImpl;
import olympic.main.drawlots.RandomDrawLots;
import olympic.main.game.AbstractPipeline;
import olympic.main.game.Valve;
import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 进行跳水比赛的管道
 */
public class DivingPipeline implements AbstractPipeline {
    /**
     * 第一个要执行的阀门
     */
    private Valve firstDivingGame;

    /**
     * 最后一个阀门
     */
    private Valve lastDivingGame;

    /**
     * 参赛运动员组成的对象池
     */
    private final AthletePool athletePool;

    /**
     * 初始化管道类
     * @param context 比赛名称
     * @param list 参赛运动员列表
     */
    public DivingPipeline(String context, List<Athlete> list) {
        AbstractNode strategyNode = new PeopleNumberNode();
        RandomDrawLots drawLots = new RandomDrawLots(list, new PaperDrawLotsImpl(), 1, true);
        List<Athlete> randomSortedAthletes = drawLots.randomDrawLots();
        this.athletePool = new AthletePool(strategyNode.interpret(context), randomSortedAthletes);
    }

    /**
     * 添加管道中的阀门（比赛）
     *
     * @param newDivingGame 新的阀门（比赛）
     */
    @Override
    public void addContest(Valve newDivingGame) {
        if (firstDivingGame == null) {
            this.firstDivingGame = newDivingGame;
        } else {
            lastDivingGame.setNext(newDivingGame);
        }
        this.lastDivingGame = newDivingGame;
    }

    /**
     * 开始整场比赛
     */
    @Override
    public void start() {
        System.out.println("选手入场完毕,马上开始比赛！");
        DivingGame preliminaryContest = new PreliminaryContest();
        DivingGame semiFinalContest = new SemiFinals();
        DivingGame finalContest = new FinalContest();
        this.addContest(preliminaryContest);
        this.addContest(semiFinalContest);
        this.addContest(finalContest);
        athletePool.showDetail();
        ((DivingGame) firstDivingGame).takePlace(athletePool);
    }

    /**
     * 获取获奖的运动员列表
     * @return 获奖运动员列表
     */
    public List<Athlete> getWinner(){
        return athletePool.gotoCeremony(3);
    }
}
