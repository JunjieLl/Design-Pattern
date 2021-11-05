package olympic.main.opening.protectionFactory;

public class ProtectionFactory {

    /**
     * 商品数量
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

    public int getMask_num() {
        return Mask_num;
    }

    public void setMask_num(int mask_num) {
        this.Mask_num = this.Mask_num - mask_num;
    }

    public int getHandSan_num() {
        return HandSan_num;
    }

    public void setHandSan_num(int handSan_num) {
        this.HandSan_num = this.HandSan_num - handSan_num;
    }

    public int getTemper_num() {
        return Temper_num;
    }

    public void setTemper_num(int temper_num) {
        this.Temper_num = this.Temper_num - temper_num;
    }

    public int getGlove_num() {
        return Glove_num;
    }

    public void setGlove_num(int glove_num) {
        this.Glove_num = this.Glove_num - glove_num;
    }

    /**
     * 设计模式：简单工厂模式
     *
     * @param fac 1
     * @param type 1
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
