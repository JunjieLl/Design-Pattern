package olympic.scene;

import olympic.main.preCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.director.Mode;
import olympic.main.game.badminton.BadmintonPipeline;
import olympic.picture.OutputPicture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("羽毛球比赛场景")
class BadmintonGameSceneTest {

    /**
     * 测试BadmintonGameScene
     */
    @Test
    void test(){
        System.out.println("【羽毛球Scene】请选择是否展示细节，输入true展示细节，输入其他不展示");
        Mode.setShowDetail(false);
        Mode.setNeedDetail(false);
        OutputPicture.printPictureOf(10);
        BadmintonPipeline badmintonPipeline = new BadmintonPipeline("羽毛球单人赛",
                PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("Badminton"));
        badmintonPipeline.start();
        new CeremonyScene(badmintonPipeline.getTopThreeAthletes()).play();
        badmintonPipeline = new BadmintonPipeline("羽毛球混双",
                PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("BadmintonTeam"));
        badmintonPipeline.start();
        new CeremonyScene(badmintonPipeline.getTopThreeAthletes()).play();
    }
}

