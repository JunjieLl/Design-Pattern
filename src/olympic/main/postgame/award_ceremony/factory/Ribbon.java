package olympic.main.postgame.award_ceremony.factory;

/**
 * 抽象地表示缎带的类.
 */
public abstract class Ribbon extends Part{
    protected String color;
    public Ribbon(String name, String color) {
        super(name);
        this.color = color;
    }
}
