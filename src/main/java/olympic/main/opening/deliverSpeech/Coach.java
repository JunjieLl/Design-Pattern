package olympic.main.opening.deliverSpeech;

import olympic.main.person.Person;

public class Coach extends Person implements Speechable{


    public Coach(String name, String nation) {
        super(name, nation);
    }

    public void deliverSpeech(){
        System.out.println("大家好，我是Coach"+this.getName()+",我会严格遵循竞赛规则和裁判员纪律！");
    }


}
