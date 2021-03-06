package olympic.main.postgame.awardceremony.olympicmedalfactory;

import olympic.utils.PrintBlockFormat;
import olympic.main.postgame.awardceremony.factory.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的产品类
 */
public class OlympicMedalEndProduct extends EndProduct {
    /**
     * 具体产品的名字
     *
     * @param productName 产品名
     */
    public OlympicMedalEndProduct(String productName) {
        super(productName);
    }

    /**
     * 具体产品的展示函数.
     */
    @Override
    public void makeMedal() {
        System.out.println("\nclassname: (OlympicMedalEndProduct) method: (makeMedal) action: (抽象工厂模式的具体产品类展示奥运奖牌的产品) ");
        List<String> endProductDisplayBlock = new ArrayList<>();
        endProductDisplayBlock.add("奖牌成品展示");
        endProductDisplayBlock.add("每块奖牌由牌子和绶带组成，以下分别为牌子工厂和绶带工厂制作的零件。");
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(endProductDisplayBlock, true);

        for (Part part : content) {
            part.makeMedal();
        }
    }
}
