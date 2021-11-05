package olympic.main.postgame.chores;

import olympic.Utils.PrintBlockFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * 表示杂务的类.
 */
public class ChoreLeaf extends ChoreComponent {

    /**
     * 单个杂务的名字
     */
    private String name;

    /**
     * 单个杂务的剩余问题数
     */
    private int remainTrouble;

    /**
     * 单个杂务的所属问题单元
     */
    private int parentUnit;

    /**
     * @param name          该项杂务的名称.
     * @param remainTrouble 当前杂务剩余的待处理问题.
     * @param parentUnit    该杂务属于哪个小组的管辖范围.
     */
    public ChoreLeaf(String name, int remainTrouble, int parentUnit) {
        this.name = name;
        this.remainTrouble = remainTrouble;
        this.parentUnit = parentUnit;
    }

    /**
     * @return 返回剩余问题数
     */
    @Override
    public int getRemainTrouble() {
        return remainTrouble;
    }

    /**
     * @return 返回单个杂务的名字
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return 返回所属单元
     */
    public int getParentUnit() {
        return parentUnit;
    }

    /**
     * 打印当前单个杂务
     *
     * @param prefix 获取杂务项的所属单元
     */
    @Override
    protected void printList(String prefix) {
        List<String> choreLeafPrintBlock = new ArrayList<>();
        System.out.println("\nclassname: (ChoreComposite) method: (printList) action: (组合模式显示单个杂务项) ");
        choreLeafPrintBlock.add("展示当前杂务及其所属");
        choreLeafPrintBlock.add(prefix + "/" + this);
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(choreLeafPrintBlock,true);
    }

    /**
     * 单个杂务接受访问者
     *
     * @param v 当前的访问者
     */
    public void accept(ChoreVisitor v) {
        v.visit(this);
    }

    /**
     * 设定当前杂物的剩余问题
     *
     * @param remainTrouble 剩余问题数
     */
    public void setRemainTrouble(int remainTrouble) {
        this.remainTrouble = remainTrouble;
    }

    /**
     * @return 单个杂务的转换字符串输出
     */
    public String toString() {
        return "【"+getName()+"】" + "\t" + "还剩" + getRemainTrouble() + "件事";
    }
}
