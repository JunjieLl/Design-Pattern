package olympic.main.opening.fireworkshow;

import java.util.Scanner;

public class LightShow extends Decorator {
    public LightShow(Show show) {
        super(show);
    }

    private void lightShow() {

        System.out.println("class:(LightShow) methods: (lightShow) action:(运动场外新增加了灯光秀表演)");
//        System.out.println("运动场外新增加了灯光秀表演");
    }

    public void operation() {
        System.out.println("您想要增加灯光表演吗? [yes/no]");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (option.equals("yes")) {
            lightShow();
        }

    }

}
