package olympic.scene;

import olympic.main.opening.deliverspeech.Speech32thClose;
import olympic.main.opening.deliverspeech.Speech32thOpen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("闭幕式演讲场景")
public class CloseSpeechSceneTest {
    /**
     * 闭幕式发表演讲测试函数
     */
    @Test
    void testPlay()
    {
        Speech32thClose oly32_1 = new Speech32thClose();
        oly32_1.deliverSpeech();
    }
}
