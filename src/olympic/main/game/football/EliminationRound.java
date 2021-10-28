package olympic.main.game.football;

import olympic.main.game.ScheduleIterator;
import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.ArrayList;

public class EliminationRound extends Round implements Observer{
    String name = null;
    private ArrayList<FootballTeam> advancedTeams = new ArrayList<>();

    public EliminationRound() {
    }

    public EliminationRound(String name) {
        this.name = name;
    }

    @Override
    public ArrayList<FootballTeam> play(ArrayList<FootballTeam> teams) {
        for (int i = 0; i < teams.size(); i += 2) {
            EliminationFootballGame g = new EliminationFootballGame(teams.get(i), teams.get(i + 1));
            g.setObserver(this);
            schedule.addGame(g);

        }

        if (name != null) {
            System.out.println("\n【" + name + "】");
        }

        ScheduleIterator it = schedule.iterator();
        while (it.hasNext()) {
            it.next().start();
        }

        return advancedTeams;
    }

    @Override
    public void update(FootballGame game) {
        if (game.getScore1() > game.getScore2()) {
            advancedTeams.add(game.getTeam1());
        } else if (game.getScore1() < game.getScore2()) {
            advancedTeams.add(game.getTeam2());
        } else if (game.getPenaltyScore1() > game.getPenaltyScore2()) {
            advancedTeams.add(game.getTeam1());
        } else {
            advancedTeams.add(game.getTeam2());
        }
    }
}
