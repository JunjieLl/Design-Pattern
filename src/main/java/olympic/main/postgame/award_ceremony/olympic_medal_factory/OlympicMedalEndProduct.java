package olympic.main.postgame.award_ceremony.olympic_medal_factory;

import olympic.main.postgame.award_ceremony.factory.*;

import java.util.Iterator;

public class OlympicMedalEndProduct extends EndProduct {
    public OlympicMedalEndProduct(String productName) {
        super(productName);
    }

    /**
     * 具体产品的展示函数.
     */
    @Override
    public void makeMedal() {
        System.out.println("\nclassname: (OlympicMedalEndProduct) method: (makeMedal) action: (展示奥运奖牌的产品) ");
        System.out.println("这是一块完整的奥运奖牌.....");
        Iterator it = content.iterator();
        while (it.hasNext()) {
            Part part = (Part) it.next();
            part.makeMedal();
        }
        System.out.println("...这块奥运奖牌已制作完成。");
    }

}
