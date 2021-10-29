package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

public class MaInTest {
    public static void main(String[] args) {
        Athlete[] runners=new Athlete[32];
        Relays relays=new Relays(runners);
        relays.start();

    }
}
