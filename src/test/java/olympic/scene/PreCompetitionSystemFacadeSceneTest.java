package olympic.scene;

import olympic.main.director.Mode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 赛前准备的测试类
 */
@DisplayName("赛前准备场景")
public class PreCompetitionSystemFacadeSceneTest {
	
	/**
	 * 测试个人比赛的项目
	 */
	@Test
	void testIndividualGamePreCompetitionSystemFacadeScene() {
		Mode.setNeedDetail(false);
		PreCompetitionSystemFacadeScene preCompetitionSystemFacadeScene = new PreCompetitionSystemFacadeScene();
		preCompetitionSystemFacadeScene.setGameName("Pingpong");
		preCompetitionSystemFacadeScene.play();
	}
	
	/**
	 * 测试团队比赛的项目
	 */
	@Test
	void testTeamGamePreCompetitionSystemFacadeScene() {
		Mode.setNeedDetail(false);
		PreCompetitionSystemFacadeScene preCompetitionSystemFacadeScene = new PreCompetitionSystemFacadeScene();
		preCompetitionSystemFacadeScene.setGameName("Relays");
		preCompetitionSystemFacadeScene.play();
	}
}
