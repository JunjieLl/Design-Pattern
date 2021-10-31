package olympic.scene.DeliverSpeech;

import olympic.main.person.Person;

abstract class Chairman extends Person implements Speech{

    protected Chairman(String name, String nation) {
        super(name, nation);
    }
//abstract class Chairman implements Speech{

    public abstract void speech();

}
