package olympic.scene;

import olympic.main.preCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.director.Mode;
import olympic.main.game.pingponggame.PingpongPipeline;
import olympic.picture.OutputPicture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("乒乓球比赛场景")
class PingpongGameSceneTest {

    /**
     * 测试PingpongGameScene
     */
    @Test
    void test() {
        System.out.println("【乒乓球Scene】请选择是否展示细节，输入true展示细节，输入其他不展示");
        Mode.setShowDetail(false);
        Mode.setNeedDetail(false);
        OutputPicture.printPictureOf(10);
        PingpongPipeline pingpongPipeline = new PingpongPipeline("乒乓球单人赛",
                PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("Pingpong"));
        pingpongPipeline.start();
        new CeremonyScene(pingpongPipeline.getTopThreeAthletes()).play();
        pingpongPipeline = new PingpongPipeline("乒乓球混双",
                PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("PingpongTeam"));
        pingpongPipeline.start();
        new CeremonyScene(pingpongPipeline.getTopThreeAthletes()).play();
    }
}

