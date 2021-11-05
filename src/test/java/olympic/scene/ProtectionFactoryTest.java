package olympic.scene;

import olympic.utils.PrintBlockFormat;
import olympic.main.opening.protectionFactory.ProtectionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;


@DisplayName("领取防疫物资测试")
public class ProtectionFactoryTest {
    /**
     * 领取防疫物资测试函数
     */
    @Test
    void test()
    {
        ProtectionFactory factory1 = ProtectionFactory.getInstance();
        ProtectionFactory factory2 = ProtectionFactory.getInstance();

        factorytest(factory1, factory2);
    }

    /**
     * 防疫工厂封装测试
     * @param factory1 工厂1（测试单例）
     * @param factory2 工厂2（测试单例）
     */
    @Test
    public static void factorytest(ProtectionFactory factory1, ProtectionFactory factory2) {
        String key;
        do {
            System.out.print("请输入需要的口罩个数(各个物资100件)：");
            Scanner sc = new Scanner(System.in);
            int number = Integer.parseInt(sc.next());
            if(number>factory1.getMask_num())
            {
                number=factory1.getMask_num();
                System.out.println("超过口罩剩余数，您还可以领取"+number+"个口罩");
            }
            factory1.produce(factory1, "Mask").get(number);

            System.out.print("请输入需要的洗手液瓶数：");
            sc = new Scanner(System.in);
            number = Integer.parseInt(sc.next());
            if(number>factory1.getHandSan_num())
            {
                number=factory1.getHandSan_num();
                System.out.println("超过洗手液剩余数，您还可以领取"+number+"瓶洗手液");
            }
            factory1.produce(factory1, "HandSanitizer").get(number);

            System.out.print("请输入需要的测温枪个数：");
            sc = new Scanner(System.in);
            number = Integer.parseInt(sc.next());
            if(number>factory2.getTemper_num())
            {
                number=factory2.getTemper_num();
                System.out.println("超过测温枪剩余数，您还可以领取"+number+"个测温枪");
            }
            factory2.produce(factory2, "TemperatureGun").get(number);

            System.out.print("请输入需要的手套件数：");
            sc = new Scanner(System.in);
            number = Integer.parseInt(sc.next());
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
            System.out.println("是否要继续领取防疫物资？[1:继续,其他:退出]");
            sc = new Scanner(System.in);
            key = sc.next();
        } while (key.equals("1"));
        System.out.println("--------------------防疫物资领取完毕----------------------");
    }
}
