package olympic.main.postgame.chores;

/**
 * 对于组合杂务与具体杂务这个数据结构的访问者类.
 */
public abstract class ChoreVisitor {
    /**
     * @param choreComposite 访问组合杂务
     */
    public abstract void visit(ChoreComposite choreComposite);

    /**
     * @param choreLeaf 访问单个杂务
     */
    public abstract void visit(ChoreLeaf choreLeaf);
}