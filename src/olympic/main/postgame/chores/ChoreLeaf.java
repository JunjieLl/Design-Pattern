package olympic.main.postgame.chores;

/**
 * 表示杂务的类.
 */
public class ChoreLeaf extends ChoreComponent{
    private String name;
    private int remainTrouble;
    private int parentUnit;

    /**
     * @param name 该项杂务的名称.
     * @param remainTrouble 当前杂务剩余的待处理问题.
     * @param parentUnit 该杂务属于哪个小组的管辖范围.
     */
    public ChoreLeaf(String name, int remainTrouble, int parentUnit){
        this.name = name;
        this.remainTrouble = remainTrouble;
        this.parentUnit = parentUnit;
    }

    @Override
    public int getRemainTrouble() {
        return remainTrouble;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getParentUnit() {
        return parentUnit;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println("\nclassname: (ChoreLeaf) method: (printList) action: (显示杂务项) ");
        System.out.println(prefix + "/" + this);
    }

    public void accept(ChoreVisitor v){
        v.visit(this);
    }

    public void setRemainTrouble(int remainTrouble) {
        this.remainTrouble = remainTrouble;
    }

    public String toString(){
        return getName() + "\t"+"还剩"+getRemainTrouble()+ "件事";
    }
}
