package olympic.scene;

import olympic.main.opening.protectionFactory.ProtectionFactory;
import olympic.main.opening.protectionFactory.Test;

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
        String key = "1";
        Test.test(factory1, factory2);
    }
}
