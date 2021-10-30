package olympic.main.game.diving;

import olympic.main.person.athlete.Athlete;

import java.util.List;

public class ContestPipeline implements AbstractPipeline{
    private DivingGame firstDivingGame;
    private DivingGame lastDivingGame;
    private final AthletePool athletePool;

    ContestPipeline(String context, List<Athlete> list) {
        AbstractNode strategyNode = new PeopleNumberNode();
        this.athletePool = new AthletePool(strategyNode.interpret(context), list);
        System.out.println("sssssssssssssss"+list.size());
    }

    @Override
    public void addContest(DivingGame newDivingGame) {
        if(firstDivingGame == null){
            this.firstDivingGame = newDivingGame;
        }else {
            lastDivingGame.setNext(newDivingGame);
        }
        this.lastDivingGame = newDivingGame;
    }

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
