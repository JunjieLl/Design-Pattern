package olympic.main.game.track;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.person.PersonFactory;


public class MaInTest {
    public static void main(String[] args) {



        Relays relays=new Relays(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("Relays"));
        relays.start();
        Marathon marathon=new Marathon(PersonFactory.getInstance().getAthletes("Marathon"));
        marathon.start();
        Hurdling track=new Hurdling(PersonFactory.getInstance().getAthletes("Hurdling"));
        track.start();

    }
}

