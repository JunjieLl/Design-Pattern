package olympic.main.postgame.award_ceremony.prototype_framework;

public interface MedalProduct extends Cloneable {
    public abstract void use(String s);
    public abstract MedalProduct createClone();
}
