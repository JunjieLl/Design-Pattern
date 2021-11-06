package olympic.scene;

import olympic.main.director.Sleep;
import olympic.main.game.volleyball.VolleyballGameManager;
import olympic.main.game.volleyball.round.EliminationRound;
import olympic.main.game.volleyball.round.GroupRound;
import olympic.main.person.PersonFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("排球比赛场景")
class VolleyballSceneTest {
    /**
     * 测试BasketballScene.play()方法
     */
    @Test
    void testPlay() {
        Sleep.setNeedSleep(false);
        VolleyballGameManager volleyballGameManager = VolleyballGameManager.getInstance();  // Singleton获取实例
        volleyballGameManager.setTeams(PersonFactory.getInstance().getAthletes("VolleyballTeam"));
        volleyballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound("四分之一决赛")).setNext(new EliminationRound("半决赛")).setNext(new EliminationRound("决赛"));  // 各轮比赛连接成管道
        volleyballGameManager.start();
    }
}
