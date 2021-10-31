package olympic.scene.DeliverSpeech;

import olympic.main.person.Person;

class Chairman extends Person implements Speech{

    protected Chairman(String name, String nation) {
        super(name, nation);
    }
//abstract class Chairman implements Speech{

    public void speech() {
        System.out.println("我是"+this.name);
    }

}
