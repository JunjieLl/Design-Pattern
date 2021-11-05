package olympic.main.postgame.awardceremony.factory;

/**
 * 抽象地表示缎带的类.
 */
public abstract class Ribbon extends Part {
    /**
     * 缎带的颜色
     */
    protected String color;

    /**
     * 缎带的构造函数
     *
     * @param name 缎带名字
     * @param color 缎带的颜色
     */
    public Ribbon(String name, String color) {
        super(name);
        this.color = color;
    }
}
