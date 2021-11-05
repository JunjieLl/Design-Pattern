package olympic.main.opening.fireworkshow;

import java.util.Scanner;

public class LightShow extends Decorator {
    /**
     * 设计模式：装饰器模式
     * 灯光秀构造函数
     * @param show
     */
    public LightShow(Show show) {
        super(show);
    }

    /**
     * 新增灯光秀
     */
    private void lightShow() {

        System.out.println("class:(LightShow) methods: (lightShow) action:(运动场外新增加了灯光秀表演)");
//        System.out.println("运动场外新增加了灯光秀表演");
    }

    /**
     * 灯光秀表演
     */
    public void operation() {
        System.out.println("您想要增加灯光表演吗? [yes/no]");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (option.equals("yes")) {
            lightShow();
        }

    }

}
