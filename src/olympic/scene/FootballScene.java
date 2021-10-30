package olympic.scene;

import olympic.main.game.football.FootballGameManager;
import olympic.main.game.football.round.EliminationRound;
import olympic.main.game.football.round.GroupRound;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * 足球比赛启动器
 * 调用start方法进行所有比赛
 */
public class FootballScene implements Scene {

    @Override
    public void play() {
        FootballGameManager footballGameManager = FootballGameManager.getInstance();
        List<Athlete> teamList = PersonFactory.getInstance().getAthletes("FootballTeam");
        // TODO: 替换为从配置文件中读入参赛球队
        footballGameManager.setTeams(teamList);
        footballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound("四分之一决赛")).setNext(new EliminationRound("半决赛")).setNext(new EliminationRound("决赛"));
        footballGameManager.start();
    }
}
