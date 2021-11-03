package olympic.main.postgame.chores;

/**
 * 解决与现场观众相关的问题的类.
 */
public class AudienceSupport extends Support {
    private int unit;

    public AudienceSupport(String name, int unit) {
        super(name);
        this.unit = unit;
    }

    @Override
    protected boolean resolve(ChoreLeaf choreleaf) {
        if (choreleaf.getParentUnit() == this.unit) {
            choreleaf.setRemainTrouble(0);
            return true;
        } else {
            return false;
        }
    }
}
