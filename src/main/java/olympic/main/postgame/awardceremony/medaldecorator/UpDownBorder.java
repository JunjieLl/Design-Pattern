package olympic.main.postgame.awardceremony.medaldecorator;

/**
 * 一种具体的装饰边框，用来在被装饰物的上下添加花纹.
 */
public class UpDownBorder extends Border {
    /**
     * 装饰字符
     */
    private char borderChar;

    /**
     * 上下边框构造函数
     *
     * @param display    被装饰的内容
     * @param borderChar 装饰字符
     */
    public UpDownBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    /**
     * @return 返回装饰后内容的列数.
     */
    @Override
    public int getColumns() {
        return display.getColumns();
    }

    /**
     * @return 返回装饰后内容的行数.
     */
    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    /**
     * 返回某一行的内容
     *
     * @param row 某一行的索引
     * @return 返回该行的文字字符串.
     */
    @Override
    public String getRowText(int row) {
        if (row == 0 || row == display.getRows() + 1) {
            return makeLine(borderChar, display.getColumns());
        } else {
            return display.getRowText(row - 1);
        }

    }

    /**
     * 构造一整行相同字符
     *
     * @param ch    要重复显示的字符.
     * @param count 重复显示的次数.
     * @return 返回将该字符重复显示指定次数后的字符串.
     */
    private String makeLine(char ch, int count) {
        return String.valueOf(ch).repeat(Math.max(0, count));
    }
}