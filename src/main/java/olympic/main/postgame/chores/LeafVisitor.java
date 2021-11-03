package olympic.main.postgame.chores;

import java.util.Iterator;

/**
 * 具体的访问单项杂务的访问者类.
 */
public class LeafVisitor extends ChoreVisitor {

    private Support currentSupport;

    public LeafVisitor(Support support) {
        this.currentSupport = support;
    }

    /**
     * 将当前要处理的杂务抛向责任链.
     *
     * @param choreLeaf 当前要处理的杂务
     */
    public void visit(ChoreLeaf choreLeaf) {
        System.out.println(choreLeaf);
        currentSupport.support(choreLeaf);
    }

    /**
     * 遇到组合杂务时进入其中寻找单项杂务.
     *
     * @param choreComposite 当前组合杂务
     */
    public void visit(ChoreComposite choreComposite) {
        Iterator it = choreComposite.iterator();
        while (it.hasNext()) {
            ChoreComponent component = (ChoreComponent) it.next();
            component.accept(this);
        }
    }
}
