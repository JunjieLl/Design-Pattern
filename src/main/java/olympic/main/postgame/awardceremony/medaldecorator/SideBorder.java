package olympic.main.postgame.awardceremony.medaldecorator;

/**
 * 一种具体的装饰边框，向被装饰物的两侧添加花纹.
 */
public class SideBorder extends Border {
    /**
     * 装饰字符
     */
    private final char borderChar;

    /**
     * 测边框构造函数
     *
     * @param display    被装饰物.
     * @param borderChar 向被装饰物两侧添加的花纹字符.
     */
    public SideBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    /**
     * @return 返回装饰后内容的列数.
     */
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    /**
     * @return 返回装饰后内容的行数.
     */
    @Override
    public int getRows() {
        return display.getRows();
    }

    /**
     * 返回某一行的显示内容
     *
     * @param row 某一行的索引.
     * @return 返回该行的文字字符串.
     */
    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
