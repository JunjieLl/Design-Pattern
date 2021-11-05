package olympic.scene;

import olympic.main.opening.deliverspeech.Speech32thOpen;

/**
 * 设计模式：模板方法模式
 * 钩子方法判断函数
 * 开幕式主席发表演讲
 */
public class OpenSpeechScene implements Scene {

    /**
     * 运行场景
     */
    @Override
    public void play() {
        Speech32thOpen oly32 = new Speech32thOpen();
        oly32.deliverSpeech();
    }
}
