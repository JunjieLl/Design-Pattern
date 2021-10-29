package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.Arrays;
import java.util.List;

public class MaInTest {
    public static void main(String[] args) {
        List<Athlete>  runners= Arrays.asList(new Athlete[32]);
        Relays relays=new Relays(runners);
        relays.start();

    }
}
