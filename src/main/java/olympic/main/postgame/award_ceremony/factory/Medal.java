package olympic.main.postgame.award_ceremony.factory;

/**
 * 抽象地表示奖牌的类.
 */
public abstract class Medal extends Part {
    /**
     * 牌子的材料
     */
    protected String material;

    /**
     * 牌子的构造函数
     *
     * @param name     牌子的名字
     * @param material 牌子的材料
     */
    public Medal(String name, String material) {
        super(name);
        this.material = material;
    }
}
