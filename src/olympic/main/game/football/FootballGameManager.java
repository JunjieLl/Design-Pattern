package olympic.main.game.football;

import olympic.main.game.football.round.Round;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton模式
 * Pipeline模式 相当于Pipeline类
 */
public class FootballGameManager {
    private static FootballGameManager singleton = new FootballGameManager();

    public static FootballGameManager getInstance() {
        return singleton;
    }

    private FootballGameManager() {
    }

    private List<FootballTeam> teams = new ArrayList<>();
    private Round first = null;

    public Round getFirst() {
        return this.first;
    }

    public Round setFirst(Round first) {
        this.first = first;
        return this.first;
    }

    public void setTeams(List<Athlete> teams) {
        for (int i = 0; i < 16; ++i) {
            this.teams.add((FootballTeam)(teams.get(i)));
        }
    }

//    public void initTeam(List<TeamAthlete> teamList) {
//        for (int i = 0; i < 16; i++) {
//            TeamAthlete team = teamList.get(i);
//            teams.add(new FootballTeam(team.getName(), team.getNation(), team.getAthleteList()));
//        }
//    }

    public void start() {
        Round r = this.first;
        while (r != null) {
            teams = r.play(teams);
            r = r.getNext();
        }

        System.out.println("足球比赛冠军为" + teams.get(0).getNation());
    }
}
