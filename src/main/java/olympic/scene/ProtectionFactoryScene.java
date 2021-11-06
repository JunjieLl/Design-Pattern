package olympic.scene;

import olympic.main.opening.protectionfactory.ProtectionFactory;
import olympic.utils.PrintBlockFormat;

import java.util.Scanner;

/**
 * 设计模式：工厂模式、单例模式
 * 领取防疫物资
 */
public class ProtectionFactoryScene implements Scene {

    /**
     * 运行场景
     */
    @Override
    public void play() {
        ProtectionFactory factory1 = ProtectionFactory.getInstance();
        ProtectionFactory factory2 = ProtectionFactory.getInstance();
        factoryTest(factory1, factory2);
    }
    /**
     * 防疫工厂函数
     */
    public static void factoryTest(ProtectionFactory factory1, ProtectionFactory factory2) {
        String key;
        int number;
        do {
            System.out.print("请输入需要的口罩个数(各个物资100件)：");
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt())   //是数字，可以继续运行
            {
                number = Integer.parseInt(sc.next());
                if(number>factory1.getMask_num())
                {
                    number=factory1.getMask_num();
                    System.out.println("超过口罩剩余数，您还可以领取"+number+"个口罩");
                }
                else if(number<0)
                {
                    number=0;
                    System.out.println("输入数量小于0，默认为不领取口罩");
                }
                factory1.produce(factory1, "Mask").get(number);

            }
            else
            {
                number=0;
                System.out.println("输入数量错误，默认为不领取口罩");
                factory1.produce(factory1, "Mask").get(number);
            }

            System.out.print("请输入需要的洗手液瓶数：");
            sc = new Scanner(System.in);
            if(sc.hasNextInt())
            {
                number = Integer.parseInt(sc.next());
                if(number>factory1.getHandSan_num())   //数字大于洗手液个数
                {
                    number=factory1.getHandSan_num();
                    System.out.println("超过洗手液剩余数，您还可以领取"+number+"瓶洗手液");
                }
                else if(number<0)  //非法数字
                {
                    number=0;
                    System.out.println("输入数量小于0，默认为不领取洗手液");
                }
                factory1.produce(factory1, "HandSanitizer").get(number);
            }
            else
            {
                number=0;
                System.out.println("输入数量错误，默认为不领取洗手液");
                factory1.produce(factory1, "HandSanitizer").get(number);
            }

            System.out.print("请输入需要的测温枪个数：");
            sc = new Scanner(System.in);
            if(sc.hasNextInt())
            {
                number = Integer.parseInt(sc.next());
                if(number>factory2.getTemper_num())
                {
                    number=factory2.getTemper_num();
                    System.out.println("超过测温枪剩余数，您还可以领取"+number+"个测温枪");
                }
                else if(number<0)
                {
                    number=0;
                    System.out.println("输入数量小于0，默认为不领取测温枪");
                }
                factory2.produce(factory2, "TemperatureGun").get(number);
            }
            else
            {
                number=0;
                System.out.println("输入数量错误，默认为不领取测温枪");
                factory2.produce(factory2, "TemperatureGun").get(number);
            }

            System.out.print("请输入需要的手套件数：");
            sc = new Scanner(System.in);
            if(sc.hasNextInt())
            {
                number = Integer.parseInt(sc.next());
                if(number>factory2.getGlove_num())
                {
                    number=factory2.getGlove_num();
                    System.out.println("超过手套剩余数，您还可以领取"+number+"件手套");
                }
                else if(number<0)
                {
                    number=0;
                    System.out.println("输入数量小于0，默认为不领取手套");
                }
                factory2.produce(factory2, "Gloves").get(number);
            }
            else
            {
                number=0;
                System.out.println("输入数量错误，默认为不领取手套");
                factory2.produce(factory2, "Gloves").get(number);
            }
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
