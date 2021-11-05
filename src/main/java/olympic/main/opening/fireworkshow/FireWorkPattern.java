package olympic.main.opening.fireworkshow;

/**
 * 测试烟花表演
 */
public class FireWorkPattern {
    public static void main(String[] args) {
        Show myshow = new Firework();
        myshow.operation();

        Decorator myfirework = new LightShow(myshow);
        myfirework.operation();

        Decorator myairwork = new AircraftShow(myshow);
        myairwork.operation();

    }
}






