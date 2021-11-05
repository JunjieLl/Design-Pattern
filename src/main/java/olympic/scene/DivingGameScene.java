package olympic.scene;

import olympic.main.precompetitionsystem.PreCompetitionSystemFacade;
import olympic.main.game.diving.DivingPipeline;
import olympic.picture.OutputPicture;

/**
 * 跳水场景
 */
public class DivingGameScene implements Scene {

    /**
     * 名称
     */
    private final String game;


    /**
     * 构造函数
     * @param game 名字
     */
    public DivingGameScene(String game) {
        this.game = game;
    }

    /**
     * 运行场景
     */
    @Override
    public void play() {
        DivingPipeline divingGame=new DivingPipeline(game,PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
        OutputPicture.printPictureOf(11);
        divingGame.start();
        new CeremonyScene(divingGame.getWinner()).play();
    }
}
