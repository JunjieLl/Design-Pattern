package olympic.scene.fireworkshow;
import java.util.Scanner;

public class FireWorkPattern {
    public static void main(String[] args){
        Show myshow = new Firework ();
        myshow.operation();


            Decorator myfirework = new LightShow(myshow);
            myfirework.operation();


            Decorator myairwork = new AircraftShow(myshow);
            myairwork.operation();

    }
}






