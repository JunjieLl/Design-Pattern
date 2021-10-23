package olympic.main.game.football;

import olympic.main.game.ScheduleIterator;

import java.util.ArrayList;

public class EliminationRound extends Round implements Observer{
    private ArrayList<FootballTeam> advancedTeams = new ArrayList<>();

    @Override
    public ArrayList<FootballTeam> play(ArrayList<FootballTeam> teams) {
        for (int i = 0; i < teams.size(); i += 2) {
            EliminationFootballGame g = new EliminationFootballGame(teams.get(i), teams.get(i + 1));
            g.setObserver(this);
            schedule.addGame(g);

        }

        ScheduleIterator it = schedule.iterator();
        while (it.hasNext()) {
            it.next().play();
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
