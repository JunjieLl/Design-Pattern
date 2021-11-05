package olympic.scene;

import olympic.main.opening.fireworkshow.*;

public class FireworkScene implements Scene {
    @Override

    public void play() {

        Show myshow = new Firework();
        myshow.operation();

        Decorator myfirework = new LightShow(myshow);
        myfirework.operation();

        Decorator myairwork = new AircraftShow(myshow);
        myairwork.operation();
    }

    public static void main(String[] args) {
        FireworkScene fireworkScene=new FireworkScene();
        fireworkScene.play();
    }
}

