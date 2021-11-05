package olympic.scene;

import olympic.main.opening.deliverSpeech.Speech32thClose;
import olympic.main.opening.deliverSpeech.Speech32thOpen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("发表演讲测试")
public class DeliverSpeechTest {
    /**
     * 发表演讲测试函数
     */
    @Test
    void testPlay()
    {
        Speech32thOpen oly32 = new Speech32thOpen();
        oly32.deliverSpeech();
        Speech32thClose oly32_1 = new Speech32thClose();
        oly32_1.deliverSpeech();
    }
}
