package olympic.main.postgame.chores;

/**
 * 解决其他问题的类.
 */
public class OtherSupport extends Support {
    private int unit;

    public OtherSupport(String name, int unit) {
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
