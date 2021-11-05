package olympic.main.game;

/**
 * Iterator模式
 */

public interface Iterator {
    /**
     * 当前位置是否存在下一个元素
     * @return boolean
     */
    public abstract boolean hasNext();

    /**
     * 获取当前位置的元素，并指向下一个元素
     * @return 当前位置的元素
     */
    public abstract Object next();
}
