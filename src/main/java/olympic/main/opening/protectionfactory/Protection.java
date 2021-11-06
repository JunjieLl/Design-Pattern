package olympic.main.opening.protectionfactory;

/**
 * 设计模式：简单工厂模式
 * 防疫品类
 */
public abstract class Protection {
    /**
     * 单例的防疫工厂
     */
    protected ProtectionFactory factory;

    /**
     * 设计模式：简单工厂模式
     * 获取防疫品
     *
     * @param num 防疫品个数
     */
    public abstract void get(int num);

    /**
     * 设计模式：单例模式
     * 设置防疫品生产的工厂
     *
     * @param factory 对应的生产工厂
     */
    public void setFactory(ProtectionFactory factory) {
        this.factory = factory;
    }
}
