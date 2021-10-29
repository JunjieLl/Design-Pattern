package olympic.main.game.track;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;

import java.util.Arrays;
import java.util.List;

public class MaInTest {
    public static void main(String[] args) {
        List<Athlete>  runners= Arrays.asList(new Athlete[32]);
        List<Athlete>  runners2= Arrays.asList(new Athlete[8]);

        Relays relays=new Relays(runners);
        relays.start();
        Marathon marathon=new Marathon(runners2);
        marathon.start();

        PersonFactory personFactory=PersonFactory.getInstance();

    }
}
