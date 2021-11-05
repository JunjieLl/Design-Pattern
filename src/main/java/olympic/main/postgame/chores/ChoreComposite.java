package olympic.main.postgame.chores;

import olympic.utils.PrintBlockFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 表示组合杂务的类.
 */
public class ChoreComposite extends ChoreComponent {
    /**
     * 该组合杂务的名字
     */
    private String name;
    /**
     * 存放当前组合杂务所有内容的列表
     */
    private List<ChoreComponent> problemDirectory = new ArrayList<>();

    /**
     * 组合杂务的构造函数
     *
     * @param name 组合杂务名字
     */
    public ChoreComposite(String name) {
        this.name = name;
    }

    /**
     * @return 获取杂务项的名字
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return 返回该组合杂务还剩下多少问题待解决.
     */
    @Override
    public int getRemainTrouble() {
        int remain = 0;
        for (ChoreComponent component : problemDirectory) {
            remain += component.getRemainTrouble();
        }
        return remain;
    }

    /**
     * 像当前组合杂务添加杂务项
     *
     * @param component 添加到组合杂务的对象，可以是新的组合杂务，也可以直接是杂务.
     */
    public void add(ChoreComponent component) {
        problemDirectory.add(component);
    }

    /**
     * @return 当前的问题列表
     */
    public List<ChoreComponent> getProblemDirectory() {
        return this.problemDirectory;
    }

    /**
     * 打印当前杂务清单
     *
     * @param prefix 当前项的父项.
     */
    @Override
    public void printList(String prefix) {
        List<String> choreCompositePrintBlock = new ArrayList<>();
        System.out.println("\nclassname: (ChoreComposite) method: (printList) action: (组合模式显示组合杂务项) ");
        choreCompositePrintBlock.add("展示当前杂务及其所属");
        choreCompositePrintBlock.add(prefix + "/" + this);
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(choreCompositePrintBlock, true);
        for (ChoreComponent cc : problemDirectory) {
            cc.printList(prefix + "/" + name);
        }
    }

    /**
     * @param v 访问杂务清单的访问者
     */
    public void accept(ChoreVisitor v) {
        v.visit(this);
    }

    /**
     * @return 返回当前组合杂务Arraylist的迭代器.
     */
    public Iterator<ChoreComponent> iterator() {      // 生成Iterator
        return problemDirectory.iterator();
    }
}