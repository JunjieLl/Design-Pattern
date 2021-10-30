package olympic.main.postgame.chores;

/**
 * 组合杂务类和其子杂物类的父类.
 */
public abstract class ChoreComponent implements ChoreElement {
    public abstract String getName();
    public abstract int getRemainTrouble();
    protected abstract void printList(String prefix);
    public String toString(){
        return getName() + "\t"+"还剩"+getRemainTrouble()+ "件事";
    }
}
