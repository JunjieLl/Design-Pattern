package olympic.main.opening.fireworkshow;

import java.util.Scanner;

public class AircraftShow extends Decorator {
    public AircraftShow(Show show) {
        super(show);
    }

    private void aircraftShow() {
        System.out.println("class:(AircraftShow) methods: (aircraftShow) action:(运动场外新增加了无人机表演)");
//        System.out.println("运动场外新增加了无人机表演");
    }

    public void operation() {
        System.out.println("您想要增加无人机表演吗? [yes/no]");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (option.equals("yes")) {
            aircraftShow();
        }
    }

}