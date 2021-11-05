package olympic.main.opening.fireworkshow;

/**
 * 装饰器
 */
abstract public class Decorator extends Show {
    protected Show show;

    /**
     * 装饰器构造函数
     * @param show 烟花表演
     */
    public Decorator(Show show) {
        this.show = show;
    }

    /**
     * 烟花表演
     */
    public void operation() {
        show.operation();
    }
}