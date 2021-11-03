package olympic.main.postgame.award_ceremony.factory;

/**
 * 抽象地表示奖牌的类.
 */
public abstract class Medal extends Part {
    protected String meterial;

    public Medal(String name, String meterial) {
        super(name);
        this.meterial = meterial;
    }
}
