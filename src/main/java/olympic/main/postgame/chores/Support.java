package olympic.main.postgame.chores;

import olympic.Utils.PrintBlockFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决问题的类.
 */
public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(ChoreLeaf choreleaf) {
        if (resolve(choreleaf)) {
            done(choreleaf);
        } else if (next != null) {
            next.support(choreleaf);
        } else {
            fail(choreleaf);
        }
    }

    public String toString() {
        return "【" + name + "】";
    }

    protected abstract boolean resolve(ChoreLeaf choreleaf);

    protected void done(ChoreLeaf choreleaf){
        System.out.println("\nclassname: (Support) method: (done) action: (责任链模式和访问者模式，访问并解决杂务：解决成功) ");
        List<String> choreHandledPrintBlock = new ArrayList<String>();
        choreHandledPrintBlock.add("杂务解决成功");
        choreHandledPrintBlock.add(choreleaf.getName()+"已被【"+name+"】解决。");
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(choreHandledPrintBlock,true);
    }

    protected void fail(ChoreLeaf choreleaf){
        System.out.println("\nclassname: (Support) method: (fail) action: (责任链模式和访问者模式，访问并解决杂务：解决失败) ");
        List<String> choreFailedPrintBlock = new ArrayList<String>();
        choreFailedPrintBlock.add("当前杂务未能解决");
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(choreFailedPrintBlock,true);
    }
}
