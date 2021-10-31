package olympic.scene;

import olympic.scene.fireworkshow.*;

public class FireworkScene implements Scene{
    @Override
    public void play() {
        Show myshow = new Firework();
        myshow.operation();


        Decorator myfirework = new LightShow(myshow);
        myfirework.operation();


        Decorator myairwork = new AircraftShow(myshow);
        myairwork.operation();
    }
}
