package olympic.main.postgame.award_ceremony.medal_decorator;

import java.util.ArrayList;

/**
 * 用于显示多行奖牌上打印内容的类.
 */
public class TitleDisplay extends Display {
    /**
     * 要显示的一系列字符串
     */
    private ArrayList body = new ArrayList();

    /**
     * 当前显示内容的列数
     */
    private int columns = 0;

    /**
     * 向多行文本中添加一行文字.
     *
     * @param msg 添加的文字.
     */
    public void add(String msg) {
        if (msg.getBytes().length != msg.length()) {
            int numChineseChar = (msg.getBytes().length - msg.length()) / 2;
            StringBuffer sb = new StringBuffer();
            //sb.append(spaces(numChineseChar));
            sb.append(msg);
            sb.append(spaces(numChineseChar * 2));
            msg = sb.toString();
        }
        body.add(msg);
        updateColumn(msg);
    }

    /**
     * @return 返回当前奖牌文字内容的列数.
     */
    @Override
    public int getColumns() {
        return columns;
    }

    /**
     * @return 返回当前奖牌文字内容的行数.
     */
    @Override
    public int getRows() {
        return body.size();
    }

    /**
     * @param row 行的索引
     * @return 该索引对应行的文字内容
     */
    @Override
    public String getRowText(int row) {
        return (String) body.get(row);
    }

    /**
     * 每新添加一行内容调用，始终以最多字符的行之列数作为当前多行文本的列数.
     *
     * @param msg 新添加的文字.
     */
    private void updateColumn(String msg) {
        if (msg.getBytes().length == msg.length()) {
            if (msg.getBytes().length > columns) {
                columns = msg.getBytes().length;
            }
            for (int row = 0; row < body.size(); row++) {
                int fills = columns - ((String) body.get(row)).getBytes().length;
                if (fills > 0) {
                    body.set(row, body.get(row) + spaces(fills));
                }
            }
        } else {
            if (msg.getBytes().length + (msg.getBytes().length - msg.length()) > columns) {
                columns = msg.getBytes().length - (msg.getBytes().length - msg.length());
            }
            for (int row = 0; row < body.size(); row++) {
                if (((String) body.get(row)).getBytes().length == ((String) body.get(row)).length()) {
                    int fills = columns - ((String) body.get(row)).getBytes().length;
                    if (fills > 0) {
                        body.set(row, body.get(row) + spaces(fills));
                    }
                } else {
                    int fills = columns - (((String) body.get(row)).getBytes().length + (((String) body.get(row)).getBytes().length - ((String) body.get(row)).length()));
                    if (fills > 0) {
                        body.set(row, body.get(row) + spaces(fills));
                    }
                }


            }
        }
    }

    /**
     * @param count 重复生成空格的个数.
     * @return 一个具有对应个数的空格的字符串.
     */
    private String spaces(int count) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(" ");
        }
        return buf.toString();
    }
}
