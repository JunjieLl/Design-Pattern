package olympic.scene;

import olympic.Utils.PrintBlockFormat;
import olympic.main.opening.protectionFactory.ProtectionFactory;
import olympic.main.opening.protectionFactory.Test;

import java.util.Scanner;

/**
 * 设计模式：工厂模式、单例模式
 * 领取防疫物资
 */
public class ProtectionFactoryScene implements Scene {
    @Override
    public void play() {
        ProtectionFactory factory1 = ProtectionFactory.getInstance();
        ProtectionFactory factory2 = ProtectionFactory.getInstance();
        String key = "1";
        Test.test(factory1, factory2);
    }
}
