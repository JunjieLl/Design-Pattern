package olympic.main.postgame.award_ceremony.factory;

/**
 * 抽象的零件，是 Medal 类和 Ribbon 类的父类。
 */
public abstract class Part {
    protected String name;

    public Part(String name) {
        this.name = name;
    }

    /**
     * 抽象方法，子类调用展示具体制作过程.
     */
    public abstract void makeMedal();
}
