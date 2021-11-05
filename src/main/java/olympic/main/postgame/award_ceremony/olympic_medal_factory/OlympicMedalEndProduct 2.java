package olympic.main.postgame.award_ceremony.olympic_medal_factory;

import olympic.Utils.PrintBlockFormat;
import olympic.main.postgame.award_ceremony.factory.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OlympicMedalEndProduct extends EndProduct {
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
        printBlockFormat.printFormatLeftScreen(endProductDisplayBlock,true);

        Iterator it = content.iterator();
        while (it.hasNext()) {
            Part part = (Part) it.next();
            part.makeMedal();
        }
    }

}
