package olympic.main.opening.deliverSpeech;

import olympic.main.person.Person;

public class Chairman extends Person implements Speechable {

    public Chairman(String name, String nation) {
        super(name, nation);
    }
//abstract class Chairman implements Speech{
    public void deliverSpeech(){
        System.out.println("大家好，我是chairman"+this.getName()+",圣火点燃激情,奥运传递梦想!");
    }

}
