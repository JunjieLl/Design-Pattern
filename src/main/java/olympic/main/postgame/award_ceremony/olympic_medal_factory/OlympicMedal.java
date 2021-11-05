package olympic.main.postgame.award_ceremony.olympic_medal_factory;
import olympic.utils.PrintBlockFormat;
import olympic.main.postgame.award_ceremony.factory.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象工厂具体的产品类
 */
public class OlympicMedal extends Medal {
    /**
     * @param name     奥运奖牌牌子部分的名字
     * @param meterial 牌子的材料
     */
    public OlympicMedal(String name, String meterial) {
        super(name, meterial);
    }

    /**
     * 具体的奖牌产品展示函数.
     */
    public void makeMedal() {
        System.out.println("\nclassname: (OlympicMedal) method: (makeMedal) action: (抽象工厂模式的具体零件类展示奥运奖牌的奖牌部分) ");
        List<String> medalDisplayBlock = new ArrayList<>();
        medalDisplayBlock.add("奖牌部分展示");
        medalDisplayBlock.add("这块奖牌的名字是：" + name);
        medalDisplayBlock.add("这块奖牌的材料是：" + material);
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(medalDisplayBlock, true);
    }
}
