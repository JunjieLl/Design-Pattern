package olympic.main.game.track;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;

import java.util.Arrays;
import java.util.List;

public class MaInTest {
    public static void main(String[] args) {

        Relays relays=new Relays(PersonFactory.getInstance().getAthletes("Relays"));
        relays.start();
        Marathon marathon=new Marathon(PersonFactory.getInstance().getAthletes("Marathon"));
        marathon.start();

        PersonFactory personFactory=PersonFactory.getInstance();

    }
}
