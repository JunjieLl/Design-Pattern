package olympic.main.postgame.award_ceremony.medal_decorator;

/**
 * 可以显示多行文本内容的抽象类.
 */
public abstract class Display {
    public abstract int getColumns();

    public abstract int getRows();

    public abstract String getRowText(int row);

    public final void show() {
        System.out.println("\nclassname: (Display) method: (show) action: (展示装饰好的奖牌) ");
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
