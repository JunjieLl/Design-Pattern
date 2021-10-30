package olympic.scene;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.football.FootballGameManager;
import olympic.main.game.football.round.EliminationRound;
import olympic.main.game.football.round.GroupRound;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 足球比赛启动器
 * 调用start方法进行所有比赛
 */
public class FootballScene implements Scene {

    @Override
    public void play() {
        System.out.println("classname: (FootballScene) method: (play) action: (足球比赛开始) ");
        FootballGameManager footballGameManager = FootballGameManager.getInstance();  // Singleton获取实例
        footballGameManager.setTeams(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("FootballTeam"));  // 获取队伍并进行赛前准备
        footballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound("四分之一决赛")).setNext(new EliminationRound("半决赛")).setNext(new EliminationRound("决赛"));  // 各轮比赛连接成管道
        footballGameManager.start();
    }
}
