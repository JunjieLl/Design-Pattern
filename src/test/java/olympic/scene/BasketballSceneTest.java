package olympic.scene;

import olympic.main.director.Sleep;
import olympic.main.game.basketball.BasketballGameManager;

import olympic.main.game.basketball.round.EliminationRound;
import olympic.main.game.basketball.round.GroupRound;
import olympic.main.person.PersonFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("篮球比赛场景")
class BasketballSceneTest {
    /**
     * 测试BasketballScene.play()方法
     */
    @Test
    void testPlay() {
        Sleep.setNeedSleep(false);
        BasketballGameManager basketballGameManager = BasketballGameManager.getInstance();  // Singleton获取实例
        basketballGameManager.setTeams(PersonFactory.getInstance().getAthletes("BasketballTeam"));
        basketballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound("四分之一决赛")).setNext(new EliminationRound("半决赛")).setNext(new EliminationRound("决赛"));  // 各轮比赛连接成管道
        basketballGameManager.start();
    }
}