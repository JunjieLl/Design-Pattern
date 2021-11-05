package olympic.main.postgame.award_ceremony.medal_decorator;

/**
 * 一种具体的装饰边框，给被装饰物添加上下左右四个方向的花纹.
 */
public class FullBorder extends Border {
    /**
     * 全边框的构造函数
     *
     * @param display 被装饰物.
     */
    public FullBorder(Display display) {
        super(display);
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
        return 1 + display.getRows() + 1;
    }


    /**
     * 返回某一行的内容
     *
     * @param row 行的索引
     * @return  对应行显示的内容
     */
    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return "+" + makeLine(display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) {
            return "+" + makeLine(display.getColumns()) + "+";
        } else {
            return "|" + display.getRowText(row - 1) + "|";
        }

    }

    /**
     * 构造一行重复的符号
     *
     * @param count 重复显示的次数.
     * @return 返回将该字符重复显示指定次数后的字符串.
     */
    private String makeLine(int count) {
        return "-".repeat(Math.max(0, count));
    }
}
