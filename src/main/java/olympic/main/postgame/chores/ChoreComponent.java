package olympic.main.postgame.chores;

/**
 * 组合杂务类和其子杂物类的父类.
 */
public abstract class ChoreComponent implements ChoreElement {
    /**
     * @return 获取杂务项的名字
     */
    public abstract String getName();

    /**
     * @return 获取杂务项的剩余问题数
     */
    public abstract int getRemainTrouble();

    /**
     * @param prefix 获取杂务项的所属单元
     */
    protected abstract void printList(String prefix);

    /**
     * @return 当前杂务项转换为字符串输出
     */
    public String toString() {
        return getName() + "\t" + "还剩" + getRemainTrouble() + "件事";
    }
}