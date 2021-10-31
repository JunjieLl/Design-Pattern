package olympic.main.person.athlete;

import olympic.scene.DeliverSpeech.Speech;

public class AthleteRepre extends Athlete implements Speech {
    public AthleteRepre(String name, String nation) {
        super(name, nation);
    }

    @Override
    public void speech() {

    }
}
