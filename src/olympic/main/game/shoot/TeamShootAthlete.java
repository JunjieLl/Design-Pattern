package olympic.main.game.shoot;

import olympic.main.game.Game;
import olympic.main.person.Athlete;
import olympic.main.person.athlete.TeamAthlete;

/**
 * 设计模式：装饰器模式
 */
public class TeamShootAthlete implements Athlete {
    private TeamAthlete teamAthlete = new TeamAthlete();

    @Override
    public void participate(Game game) {
        System.out.println("classname: (TeamShootAthlete) method: (participate) action: (装饰器模式中团队射击运动员参与比赛) ");
        teamAthlete.participate(game);
    }

    @Override
    public void addChild(Athlete athlete) {
        System.out.println("classname: (TeamShootAthlete) method: (participate) action: (装饰器模式中团队运射击运动员添加队员) ");
        teamAthlete.addChild(athlete);
    }
}
