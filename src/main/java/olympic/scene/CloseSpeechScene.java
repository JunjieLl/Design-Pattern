package olympic.scene;

import olympic.main.opening.deliverspeech.Speech32thClose;

/**
 * 设计模式：模板方法模式
 * 钩子方法判断函数
 * 闭幕式主席发表演讲
 */
public class CloseSpeechScene implements Scene {

    /**
     * 运行场景
     */
    @Override
    public void play() {
        Speech32thClose oly32_1 = new Speech32thClose();
        oly32_1.deliverSpeech();
    }
}
