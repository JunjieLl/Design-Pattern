package olympic.main.game.track;

import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

public class Relays extends TrackGame {

    public Relays(TeamAthlete[] teamAthletes) {
        super(teamAthletes);

    }

    @Override
    public void start() {
        System.out.println("classname: (TrackGame) method: (start) action: (template method模式中运动员参与接力比赛) ");

//        athlete.participate(this);
        /// game detail to do
    }



    public String getName(){
        return "接力比赛";
    }
}
