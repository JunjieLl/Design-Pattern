package olympic.main.postgame.awardceremony.medaldecorator;

/**
 * 可以显示多行文本内容的抽象类.
 */
public abstract class Display {
    /**
     * @return 显示内容的列数
     */
    public abstract int getColumns();

    /**
     * @return 显示内容的行数
     */
    public abstract int getRows();

    /**
     * 返回某一行显示的内容
     *
     * @param row 行的索引
     * @return 相应行显示的内容
     */
    public abstract String getRowText(int row);

    /**
     * 逐行展示显示内容
     */
    public final void show() {
        System.out.println("\nclassname: (Display) method: (show) action: (展示装饰好的奖牌) ");
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
