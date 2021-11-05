package olympic.main.postgame.chores;

import olympic.Utils.PrintBlockFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决问题的类.
 */
public abstract class Support {

    /**
     * Supporter的名字
     */
    private String name;

    /**
     * 责任链中当前Supporter的下一个Supporter
     */
    private Support next;

    /**
     * Supporter的构造函数
     *
     * @param name Supporter名字
     */
    public Support(String name) {
        this.name = name;
    }

    /**
     * 设置当前Supporter的下一个Supporter
     *
     * @param next 当前Supporter的下一个Supporter
     * @return 下一个Supporter
     */
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    /**
     * 解决杂务
     *
     * @param choreleaf 单个杂务
     */
    public final void support(ChoreLeaf choreleaf) {
        if (resolve(choreleaf)) {
            done(choreleaf);
        } else if (next != null) {
            next.support(choreleaf);
        } else {
            fail(choreleaf);
        }
    }

    /**
     * @return Supporter转换为字符串输出
     */
    public String toString() {
        return "【" + name + "】";
    }

    /**
     * @param choreleaf 单个杂务
     * @return 是否解决单个杂务
     */
    protected abstract boolean resolve(ChoreLeaf choreleaf);

    /**
     * 单个杂务被成功解决
     *
     * @param choreleaf 单个杂务
     */
    protected void done(ChoreLeaf choreleaf) {
        System.out.println("\nclassname: (Support) method: (done) action: (责任链模式和访问者模式，访问并解决杂务：解决成功) ");
        List<String> choreHandledPrintBlock = new ArrayList<>();
        choreHandledPrintBlock.add("杂务解决成功");
        choreHandledPrintBlock.add("【" + choreleaf.getName() + "】" + "已被【" + name + "】解决。");
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(choreHandledPrintBlock, true);
    }

    /**
     * 单个杂务无法被解决
     *
     * @param choreleaf 单个杂务
     */
    protected void fail(ChoreLeaf choreleaf) {
        System.out.println("\nclassname: (Support) method: (fail) action: (责任链模式和访问者模式，访问并解决杂务：解决失败) ");
        List<String> choreFailedPrintBlock = new ArrayList<>();
        choreFailedPrintBlock.add("当前杂务 "+choreleaf+" 未能解决");
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(choreFailedPrintBlock, true);
    }
}
