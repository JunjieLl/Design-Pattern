package olympic.main.postgame.chores;

/**
 * 解决保洁问题的类.
 */
public class CleaningSupport extends Support {
    private int unit;

    public CleaningSupport(String name) {
        super(name);
        this.unit = 2;
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
