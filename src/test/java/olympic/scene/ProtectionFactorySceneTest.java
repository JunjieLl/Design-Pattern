package olympic.scene;

import olympic.utils.PrintBlockFormat;
import olympic.main.opening.protectionFactory.ProtectionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;


@DisplayName("领取防疫物资测试")
public class ProtectionFactorySceneTest {
    /**
     * 领取防疫物资测试函数
     */
    @Test
    void test()
    {
        int[] testString = new int[] {104,32,0,28};
        ProtectionFactory factory1 = ProtectionFactory.getInstance();
        ProtectionFactory factory2 = ProtectionFactory.getInstance();

        int number = testString[0];
        if(number>factory1.getMask_num())
        {
            number=factory1.getMask_num();
            System.out.println("超过口罩剩余数，您还可以领取"+number+"个口罩");
        }
        factory1.produce(factory1, "Mask").get(number);

        System.out.print("请输入需要的洗手液瓶数：");
        number = testString[1];
        if(number>factory1.getHandSan_num())
        {
            number=factory1.getHandSan_num();
            System.out.println("超过洗手液剩余数，您还可以领取"+number+"瓶洗手液");
        }
        factory1.produce(factory1, "HandSanitizer").get(number);

        System.out.print("请输入需要的测温枪个数：");
        number = testString[2];
        if(number>factory2.getTemper_num())
        {
            number=factory2.getTemper_num();
            System.out.println("超过测温枪剩余数，您还可以领取"+number+"个测温枪");
        }
        factory2.produce(factory2, "TemperatureGun").get(number);

        System.out.print("请输入需要的手套件数：");
        number = testString[3];
        if(number>factory2.getGlove_num())
        {
            number=factory2.getGlove_num();
            System.out.println("超过手套剩余数，您还可以领取"+number+"件手套");
        }
        factory2.produce(factory2, "Gloves").get(number);
        PrintBlockFormat.getPrintFormat().addString("剩余物资");
        PrintBlockFormat.getPrintFormat().addString("口罩个数剩:" + factory1.getMask_num() );
        PrintBlockFormat.getPrintFormat().addString( "洗手液瓶数剩：" + factory1.getHandSan_num());
        PrintBlockFormat.getPrintFormat().addString("测温枪个数剩:" + factory2.getTemper_num() );
        PrintBlockFormat.getPrintFormat().addString( "手套个数剩：" + factory1.getGlove_num());
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);

        System.out.println("--------------------防疫物资领取完毕----------------------");
    }
}
