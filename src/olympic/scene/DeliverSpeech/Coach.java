package olympic.scene.DeliverSpeech;

import olympic.main.person.Person;

abstract class Coach extends Person implements Speech{


    protected Coach(String name, String nation) {
        super(name, nation);
    }

    public abstract void speech();

}
