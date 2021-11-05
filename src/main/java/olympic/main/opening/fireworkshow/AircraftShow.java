package olympic.main.opening.fireworkshow;

import java.util.Scanner;

public class AircraftShow extends Decorator {
    /**
     * 设计模式：装饰器模式
     * 无人机表演构造函数
     * @param show 添加烟花表演
     */
    public AircraftShow(Show show) {
        super(show);
    }

    /**
     * 新增无人机表演
     */
    private void aircraftShow() {
        System.out.println("class:(AircraftShow) methods: (aircraftShow) action:(运动场外进行烟花表演，并且新增加了无人机表演)");
//        System.out.println("运动场外新增加了无人机表演");
    }

    /**
     *无人机表演
     */
    public void operation() {
        System.out.println("您想要增加无人机表演吗? [1:是/2:否]");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (option.equals("1")) {
            aircraftShow();
        }
        else{
            System.out.println("运动场外进行烟花表演");
        }
    }

}