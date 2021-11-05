package olympic.main.postgame.award_ceremony.factory;

/**
 * 抽象工厂. 作为具体金牌工厂的父类，根据需要选择实例化何具体工厂.
 */
public abstract class Factory {

    /**
     * 获取工厂
     *
     * @param classname 选择的具体工厂的类名.
     * @return 相应具体工厂的实例.
     */
    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(classname).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Ops, didnt find this factory: " + classname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    /**
     * 制作牌子部分
     *
     * @param name     奖牌部分的名字.
     * @param material 奖牌部分的材料.
     * @return 抽象的奖牌部分.
     */
    public abstract Medal createMedal(String name, String material);

    /**
     * 制作缎带部分
     *
     * @param name  缎带部分的名字.
     * @param color 缎带的颜色.
     * @return 抽象的缎带部分.
     */
    public abstract Ribbon createRibbon(String name, String color);

    /**
     * 制作完整奖牌产品
     *
     * @param name 奖牌产品的名字.
     * @return 抽象的奖牌产品.
     */
    public abstract EndProduct createEndProduct(String name);

}
