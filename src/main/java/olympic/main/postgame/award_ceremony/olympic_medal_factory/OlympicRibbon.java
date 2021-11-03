package olympic.main.postgame.award_ceremony.olympic_medal_factory;

import olympic.main.postgame.award_ceremony.factory.*;

public class OlympicRibbon extends Ribbon {
    public OlympicRibbon(String name, String color){
        super(name, color);
    }

    /**
     * 具体零件缎带的展示函数.
     */
    @Override
    public void makeMedal() {
        System.out.println("\nclassname: (OlympicRibbon) method: (makeMedal) action: (展示奥运奖牌的缎带部分) ");
        System.out.println("这是奖牌的缎带部分...");
        System.out.println("这种奖牌的缎带名字是"+name);
        System.out.println("这种奖牌的缎带颜色是"+color);
    }
}
