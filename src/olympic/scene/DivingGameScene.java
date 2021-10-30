package olympic.scene;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.diving.ContestPipeline;

public class DivingGameScene implements Scene{
    private final String game;

    public DivingGameScene(String game){
        this.game=game;
    }

    @Override
    public void play(){
        PreCompetitionSystemFacade pre = new PreCompetitionSystemFacade();
        ContestPipeline divingGame=new ContestPipeline(game, pre.preCompetitionSystemFacade("Diving"));
        divingGame.start();
    }
}
