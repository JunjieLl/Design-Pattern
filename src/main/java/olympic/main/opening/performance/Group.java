package olympic.main.opening.performance;

import olympic.Utils.PrintBlockFormat;

/**
 * 观察者：表演组
 */
public class Group implements Observer {
    /**
     * 命令顺序
     */
    private int order;
    /**
     * 标题名字
     */
    private String title;

    /**
     * 设计模式：观察者模式
     * 表演组构造函数
     *
     * @param order 表演顺序
     * @param title 表演名称
     */
    public Group(int order, String title) {  //两个参数的构造函数
        this.order = order;
        this.title = title;
    }

    /**
     * 观察者更新状态
     * @param arg 更新函数参数
     */
    public void update(Object arg) {
        int num = ((Integer) arg).intValue();
        if (num == order) {
            PrintBlockFormat.getPrintFormat().addString("classname: (Group) method: (update) action: (现在由第" + order + "表演组带来" + title + "节目)");
        } else if (num == order - 1) {
            PrintBlockFormat.getPrintFormat().addString("classname: (Group) method: (update) action: (第" + order + "表演组正在准备)");
        } else {
            PrintBlockFormat.getPrintFormat().addString("classname: (Group) method: (update) action: (第" + order + "表演组正在休息)");
        }
    }
}