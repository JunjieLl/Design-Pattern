package olympic.scene.fireworkshow;
import java.util.Scanner;

public class FireWorkPattern {
    public static void main(String[] args){
        Show myshow = new Firework ();
        myshow.operation();

        System.out.println("您想要增加灯光表演吗? [yes/no]");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if(option.equals("yes")) {
            Decorator myfirework = new LightShow(myshow);
            myfirework.operation();
        }
        System.out.println("您想要增加无人机表演吗? [yes/no]");
        sc = new Scanner(System.in);
        option = sc.next();
        if(option.equals("yes")) {
            Decorator myairwork = new AircraftShow(myshow);
            myairwork.operation();
        }
    }
}






