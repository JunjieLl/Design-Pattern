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

        ContestPipeline divingGame=new ContestPipeline(game,PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("Diving"));
        divingGame.start();
    }
}
