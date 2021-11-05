package olympic.main.postgame.award_ceremony.olympic_medal_factory;

import olympic.utils.PrintBlockFormat;
import olympic.main.postgame.award_ceremony.factory.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的缎带产品类
 */
public class OlympicRibbon extends Ribbon {
    /**
     * 具体缎带的构造函数
     *
     * @param name  缎带名字
     * @param color 缎带颜色
     */
    public OlympicRibbon(String name, String color) {
        super(name, color);
    }

    /**
     * 具体零件缎带的展示函数.
     */
    @Override
    public void makeMedal() {
        System.out.println("\nclassname: (OlympicMedal) method: (makeMedal) action: (抽象工厂模式的具体零件类展示奥运奖牌的绶带部分) ");
        List<String> ribbonDisplayBlock = new ArrayList<>();
        ribbonDisplayBlock.add("缎带部分展示");
        ribbonDisplayBlock.add("这个缎带的名字是：" + name);
        ribbonDisplayBlock.add("这个缎带的颜色是：" + color);
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(ribbonDisplayBlock, true);
    }
}
