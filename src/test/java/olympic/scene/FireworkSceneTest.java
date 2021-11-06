package olympic.scene;

import olympic.main.opening.fireworkshow.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("烟花场景")
class FireworkSceneTest {
    /**
     * 测试FireworkScene.play()方法
     */

    @Test
    void test(){
        Show myshow = new Firework();
        myshow.operation();

        Decorator myfirework = new LightShow(myshow);
        Decorator myairwork = new AircraftShow(myshow);
        System.out.println("class:(AircraftShow) methods: (aircraftShow) action:(运动场外进行烟花表演，并且新增加了无人机表演)");
        System.out.println("class:(LightShow) methods: (lightShow) action:(运动场外进行烟花表演，并且新增加了灯光秀表演)");

    }

}
