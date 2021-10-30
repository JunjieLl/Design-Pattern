package olympic.main.game.diving;

import olympic.main.person.athlete.Athlete;

import java.util.LinkedList;

/**
 * 进行跳水比赛的管道
 */
public class ContestPipeline implements AbstractPipeline{
    private DivingGame firstDivingGame;
    private DivingGame lastDivingGame;
    private final AthletePool athletePool;

    ContestPipeline(String context, LinkedList<Athlete> list) {
        AbstractNode strategyNode = new PeopleNumberNode();
        this.athletePool = new AthletePool(strategyNode.interpret(context), list);
    }

    /**
     * 添加管道中的阀门（比赛）
     * @param newDivingGame 新的阀门（比赛）
     */
    @Override
    public void addContest(DivingGame newDivingGame) {
        if(firstDivingGame == null){
            this.firstDivingGame = newDivingGame;
        }else {
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
        DivingGame preliminaryContest=new PreliminaryContest();
        DivingGame semiFinalContest=new SemiFinals();
        DivingGame finalContest=new FinalContest();
        this.addContest(preliminaryContest);
        this.addContest(semiFinalContest);
        this.addContest(finalContest);
        firstDivingGame.takePlace(athletePool);
    }
}
