package olympic.scene;

import olympic.main.director.Sleep;
import olympic.main.game.football.FootballGameManager;
import olympic.main.game.football.round.EliminationRound;
import olympic.main.game.football.round.GroupRound;
import olympic.main.person.PersonFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("足球比赛场景")
class FootballSceneTest {
    /**
     * 测试FootballScene.play()方法
     */
    @Test
    void testPlay() {
        Sleep.setNeedSleep(false);
        FootballGameManager footballGameManager = FootballGameManager.getInstance();  // Singleton获取实例
        footballGameManager.setTeams(PersonFactory.getInstance().getAthletes("FootballTeam"));
        footballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound("四分之一决赛")).setNext(new EliminationRound("半决赛")).setNext(new EliminationRound("决赛"));  // 各轮比赛连接成管道
        footballGameManager.start();
    }
}