package olympic.scene;

import olympic.Utils.PrintBlockFormat;
import olympic.main.postgame.chores.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 赛后杂务处理的场景.
 */
public class ChoreHandlingScene implements Scene {

    /**
     * 杂务处理的主函数
     */
    @Override
    public void play() {
        System.out.println("\nclassname: (ChoreHandlingScene) method: (play) action: (赛后杂务处理场景) ");

        List<String> choreInitPrintBlock = new ArrayList<>();
        choreInitPrintBlock.add("杂务处理总流程");
        choreInitPrintBlock.add("1. 查看处理前杂务");
        choreInitPrintBlock.add("2. 处理杂务");
        choreInitPrintBlock.add("3. 查看处理后杂务");

        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatMiddleScreen(choreInitPrintBlock,true);
        ChoreComposite allTheChore;

        //用ChoreGenerating类来生成杂务清单.
        allTheChore = new ChoreGenerating().getGeneratedComposite();
        allTheChore.printList("杂务清单");

        System.out.println("\nclassname: (ChoreHandlingScene) method: (play) action: (开始展示杂务处理过程) ");

        List<String> choreHandlingPrintBlock = new ArrayList<>();
        choreHandlingPrintBlock.add("使用责任链处理杂务");
        choreHandlingPrintBlock.add("责任链的顺序为：观众辅助小组->保洁小组->安保小组->机动小组");

        printBlockFormat.printFormatMiddleScreen(choreHandlingPrintBlock,true);
        System.out.println("正在利用责任链处理杂务...");
        Support security = new SecuritySupport("安保小组");
        Support cleaning = new CleaningSupport("保洁小组");
        Support audience = new AudienceSupport("观众辅助小组");
        Support other = new OtherSupport("机动小组");

        //设置责任链.
        audience.setNext(cleaning).setNext(security).setNext(other);

        //添加访问者
        allTheChore.accept(new LeafVisitor(audience));

        System.out.println("\nclassname: (ChoreHandlingScene) method: (play) action: (展示处理后的杂务清单) ");
        System.out.println("处理完成，以下为当前杂务清单...");
        allTheChore.printList("杂务清单");
    }


}
