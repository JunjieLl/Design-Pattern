package olympic.main.postgame.chores;

/**
 * 解决与保洁的问题的类.
 */
public class CleaningSupport extends Support {
    /**
     * 当前Supporter的单元
     */
    private int unit;

    /**
     * @param name 当前Supporter的名字
     */
    public CleaningSupport(String name) {
        super(name);
        this.unit = 2;
    }

    /**
     * 当前Supporter的解决问题函数
     *
     * @param choreleaf 单个杂务
     * @return 能否解决的布尔值
     */
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
