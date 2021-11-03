package olympic.scene;

import olympic.main.opening.protectionFactory.ProtectionFactory;

import java.util.Scanner;

/**
 * 设计模式：工厂模式、单例模式
 * 领取防疫物资
 */
public class ProtectionFactoryScene implements Scene{
    @Override
    public void play() {
        ProtectionFactory factory1 = ProtectionFactory.getInstance();
        ProtectionFactory factory2 = ProtectionFactory.getInstance();
        String key = "1";
        do {
            System.out.print("请输入需要的口罩个数：");
            Scanner sc = new Scanner(System.in);
            Integer number = Integer.parseInt(sc.next());
            factory1.produce(factory1, "Mask").get(number);

            System.out.print("请输入需要的洗手液瓶数：");
            sc = new Scanner(System.in);
            number = Integer.parseInt(sc.next());
            factory1.produce(factory1, "HandSanitizer").get(number);

            System.out.print("请输入需要的测温枪个数：");
            sc = new Scanner(System.in);
            number = Integer.parseInt(sc.next());
            factory2.produce(factory2, "TemperatureGun").get(number);

            System.out.print("请输入需要的手套件数：");
            sc = new Scanner(System.in);
            number = Integer.parseInt(sc.next());
            factory2.produce(factory2, "Gloves").get(number);

            System.out.println("口罩个数剩:" + factory1.getMask_num() + "\n" + "洗手液瓶数剩：" + factory1.getHandSan_num());
            System.out.println("测温枪个数剩:" + factory2.getTemper_num() + "\n" + "手套个数剩：" + factory1.getGlove_num());

            System.out.println("是否要继续领取防疫物资？[1:继续,其他:退出]");
            sc = new Scanner(System.in);
            key = sc.next();
        }while(key.equals("1"));
        System.out.println("--------------------防疫物资领取完毕----------------------");
    }
}
