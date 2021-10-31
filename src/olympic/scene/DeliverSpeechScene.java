package olympic.scene;

import olympic.scene.DeliverSpeech.Speech32thClose;
import olympic.scene.DeliverSpeech.Speech32thOpen;

/**
 * 设计模式：模板方法模式
 * 钩子方法判断函数
 * 开幕/闭幕式主席发表演讲
 */
public class DeliverSpeechScene implements Scene{
    @Override
    public void play() {
        Speech32thOpen oly32 = new Speech32thOpen();
        oly32.deliverSpeech();
        System.out.println("-----------------");
        Speech32thClose oly32_1 = new Speech32thClose();
        oly32_1.deliverSpeech();
    }
}
