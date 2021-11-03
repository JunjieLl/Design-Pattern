package olympic.scene;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.diving.DivingPipeline;

public class DivingGameScene implements Scene {
    private final String game;

    public DivingGameScene(String game) {
        this.game = game;
    }

    @Override
    public void play() {

        DivingPipeline divingGame=new DivingPipeline(game,PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
        divingGame.start();
    }
}
