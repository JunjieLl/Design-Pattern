package olympic.main.opening.protectionFactory;

/**
 * 防疫物资工厂
 */
public class ProtectionFactory {

    /**
     * 防疫物资数量
     */
    private int Mask_num = 100;
    private int HandSan_num = 100;
    private int Temper_num = 100;
    private int Glove_num = 100;


    /**
     * 单例内部实例化
     */
    private static final ProtectionFactory ourInstance = new ProtectionFactory();

    /**
     * 设计模式：单例模式
     *
     * @return 防疫工厂单例
     */
    public static ProtectionFactory getInstance() {
        return ourInstance;
    }

    /**
     * 设计模式：单例模式
     * 将构造函数私有化，放置外部调用
     */
    private ProtectionFactory() {
    }

    /**
     * 获取口罩个数
     * @return 口罩个数
     */
    public int getMask_num() {
        return Mask_num;
    }

    /**
     * 返回口罩个数
     * @param mask_num 需要的口罩数量
     */
    public void setMask_num(int mask_num) {
        this.Mask_num = this.Mask_num - mask_num;
    }

    /**
     * 获取洗手液瓶数
     * @return 洗手液瓶数
     */
    public int getHandSan_num() {
        return HandSan_num;
    }

    /**
     * 返回洗手液瓶数
     * @param handSan_num 需要的洗手液瓶数
     */
    public void setHandSan_num(int handSan_num) {
        this.HandSan_num = this.HandSan_num - handSan_num;
    }

    /**
     * 获取测温枪个数
     * @return 测温枪个数
     */
    public int getTemper_num() {
        return Temper_num;
    }

    /**
     * 设置测温枪个数
     * @param temper_num 需要的测温枪个数
     */
    public void setTemper_num(int temper_num) {
        this.Temper_num = this.Temper_num - temper_num;
    }

    /**
     * 获取手套个数
     * @return 手套个数
     */
    public int getGlove_num() {
        return Glove_num;
    }

    /**
     * 设置手套个数
     * @param glove_num 需要的手套数
     */
    public void setGlove_num(int glove_num) {
        this.Glove_num = this.Glove_num - glove_num;
    }

    /**
     * 设计模式：简单工厂模式
     *
     * @param fac 对应的生产工厂
     * @param type 防疫品类型
     * @return 防疫品
     */
    public Protection produce(ProtectionFactory fac, String type) {
        Protection m;
        switch (type) {
            case "Mask":
                m = new Mask();
                m.setFactory(fac);
                return m;
            case "HandSanitizer":
                m = new HandSanitizer();
                m.setFactory(fac);
                return m;
            case "TemperatureGun":
                m = new TemperatureGun();
                m.setFactory(fac);
                return m;
            case "Gloves":
                m = new Gloves();
                m.setFactory(fac);
                return m;
            default:
                throw new IllegalArgumentException("Unsupported protection type");
        }
    }
}
