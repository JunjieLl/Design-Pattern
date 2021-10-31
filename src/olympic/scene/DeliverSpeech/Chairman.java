package olympic.scene.DeliverSpeech;

import olympic.main.person.Person;

public class Chairman extends Person implements Speech{

    public Chairman(String name, String nation) {
        super(name, nation);
    }
//abstract class Chairman implements Speech{

    public void speech() {
        System.out.println("我是"+this.name);
    }

}
