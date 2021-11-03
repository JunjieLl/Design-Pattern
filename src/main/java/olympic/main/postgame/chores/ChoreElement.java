package olympic.main.postgame.chores;

/**
 * 表示杂务数据结构的接口，接受访问者访问.
 */
public interface ChoreElement {
    public abstract void accept(ChoreVisitor v);
}
