package olympic.scene;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.basketball.BasketballGameManager;
import olympic.main.game.basketball.round.EliminationRound;
import olympic.main.game.basketball.round.GroupRound;


/**
 * 篮球比赛启动器
 * 调用play方法进行所有比赛
 */
public class BasketballScene implements Scene {

    /**
     * 进行所有比赛
     */
    @Override
    public void play() {
        System.out.println("classname: (BasketballScene) method: (play) action: (篮球比赛开始) ");
        BasketballGameManager basketballGameManager = BasketballGameManager.getInstance();  // Singleton获取实例
        basketballGameManager.setTeams(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("BasketballTeam"));
        basketballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound("四分之一决赛")).setNext(new EliminationRound("半决赛")).setNext(new EliminationRound("决赛"));  // 各轮比赛连接成管道
        basketballGameManager.start();
        new CeremonyScene(basketballGameManager.getTopThreeAthletes()).play();
    }
}