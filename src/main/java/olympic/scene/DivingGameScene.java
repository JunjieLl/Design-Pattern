package olympic.scene;

import olympic.main.preCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.diving.DivingPipeline;
import olympic.picture.OutputPicture;

public class DivingGameScene implements Scene {
    private final String game;

    public DivingGameScene(String game) {
        this.game = game;
    }

    @Override
    public void play() {
        DivingPipeline divingGame=new DivingPipeline(game,PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
        OutputPicture.printPictureOf(11);
        divingGame.start();
        new CeremonyScene(divingGame.getWinner()).play();
    }
}
