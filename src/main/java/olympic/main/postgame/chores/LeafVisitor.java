package olympic.main.postgame.chores;

import olympic.Utils.PrintBlockFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 具体的访问单项杂务的访问者类.
 */
public class LeafVisitor extends ChoreVisitor {

    /**
     * 当前访问者拥有的Supporter
     */
    private Support currentSupport;

    /**
     * 访问者构造函数
     *
     * @param support 责任链的第一个Supporter
     */
    public LeafVisitor(Support support) {
        this.currentSupport = support;
    }

    /**
     * 将当前要处理的杂务抛向责任链.
     *
     * @param choreLeaf 当前要处理的杂务
     */
    public void visit(ChoreLeaf choreLeaf) {
        System.out.println("\nclassname: (LeafVisitor) method: (visit) action: (访问者模式访问到单个杂务) ");
        List<String> choreVisitedPrintBlock = new ArrayList<>();
        choreVisitedPrintBlock.add("访问单个杂务");
        choreVisitedPrintBlock.add("下一项杂务为：");
        choreVisitedPrintBlock.add(choreLeaf.toString());
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(choreVisitedPrintBlock,true);

        currentSupport.support(choreLeaf);
    }

    /**
     * 遇到组合杂务时进入其中寻找单项杂务.
     *
     * @param choreComposite 当前组合杂务
     */
    public void visit(ChoreComposite choreComposite) {
        Iterator<ChoreComponent> it = choreComposite.iterator();
        while (it.hasNext()) {
            ChoreComponent component = it.next();
            component.accept(this);
        }
    }
}
