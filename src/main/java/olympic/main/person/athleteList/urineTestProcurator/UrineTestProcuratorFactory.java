package olympic.main.person.athleteList.urineTestProcurator;

import java.util.HashMap;

/**
 * 尿检检察员的生成工厂
 * 采用了享元模式，工厂模式，单例模式的等多种设计模式
 */
public class UrineTestProcuratorFactory {
    /**
     * 尿检检察员的对象池，用于生成整数（用于生成检察员的姓名）与尿检检察员的一一对应
     */
    private final HashMap<Integer, UrineTestProcurator> pool = new HashMap<>();
    
    /**
     * 尿检检察员生成工厂的单例
     */
    private static final UrineTestProcuratorFactory singleton = new UrineTestProcuratorFactory();
    
    /**
     * 尿检检察员工厂的构造函数，是一个私有类，用于生成对象
     */
    private UrineTestProcuratorFactory() {
    
    }
    
    /**
     * 获取尿检检察员生成工厂
     *
     * @param isPrint 控制是否输出classname语句
     * @return 尿检检察员生成工厂
     */
    public static UrineTestProcuratorFactory getInstance(boolean isPrint) {
        if(isPrint) {
            System.out.println("classname: (UrineTestProcuratorFactory) method: (getInstance) " + "action: (生成尿检检察员工厂，使用了Flyweight模式，Factory模式以及Singleton模式) ");
        }
        return singleton;
    }
    
    /**
     * 根据一个整数获取尿检检察员，如果对象池中有这个检察员，则返回这个检察员。如果没有这个检察员，
     * 则根绝输入的number生成一个检察员，并存入对象池中
     *
     * @param number 用于获取或者生成检察院的关键字
     * @return 根据输入的number获取的检察员
     */
    public synchronized UrineTestProcurator getUrineTestProcurator(int number) {
        UrineTestProcurator urineTestProcurator = pool.get(number);
        if (urineTestProcurator == null) {
            if (number < 26) {
                urineTestProcurator = new UrineTestProcuratorProxy("检察员" + ((char) ('A' + number)), "");
            } else {
                urineTestProcurator = new UrineTestProcuratorProxy("检察员" + ((Integer) (number + 1)).toString(), "");
            }
            pool.put(number, urineTestProcurator);
        }
        return urineTestProcurator;
    }
}
