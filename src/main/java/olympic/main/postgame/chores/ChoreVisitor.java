package olympic.main.postgame.chores;

/**
 * 对于组合杂务与具体杂务这个数据结构的访问者类.
 */
public abstract class ChoreVisitor {
    public abstract void visit(ChoreComposite choreComposite);
    public abstract void visit(ChoreLeaf choreLeaf);
}
