package olympic.scene.DeliverSpeech;

import olympic.main.person.Person;

class Coach extends Person implements Speech{


    protected Coach(String name, String nation) {
        super(name, nation);
    }

    public void speech() {
        System.out.println("我是"+this.name);
    }

}
