package olympic.main.opening.performance;

/**
 * 观察者：表演组
 */
public class Group implements Observer {
    private int order;
    private String title;

    /**
     * 设计模式：观察者模式
     * 表演组构造函数
     *
     * @param order
     * @param title
     */
    public Group(int order, String title) {  //两个参数的构造函数
        this.order = order;
        this.title = title;
    }

    public void update(Object arg) {
        int num = ((Integer) arg).intValue();
        if (num == order) {
            System.out.println("classname: (Group) method: (update) action: (现在由第" + order + "表演组带来" + title + "节目)");
        } else if (num == order - 1) {
            System.out.println("classname: (Group) method: (update) action: (第" + order + "表演组正在准备)");
        } else {
            System.out.println("classname: (Group) method: (update) action: (第" + order + "表演组正在休息)");
        }
    }
}