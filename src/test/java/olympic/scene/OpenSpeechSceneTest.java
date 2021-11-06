package olympic.scene;

import olympic.main.opening.deliverspeech.Speech32thClose;
import olympic.main.opening.deliverspeech.Speech32thOpen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("开幕式演讲场景")
public class OpenSpeechSceneTest {
    /**
     * 开幕式发表演讲测试函数
     */
    @Test
    void testPlay()
    {
        Speech32thOpen oly32 = new Speech32thOpen();
        oly32.deliverSpeech();
    }
}
