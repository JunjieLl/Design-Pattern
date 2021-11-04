package olympic.main.postgame.award_ceremony.olympic_medal_factory;
import olympic.Utils.PrintBlockFormat;
import olympic.main.postgame.award_ceremony.factory.*;

import java.util.ArrayList;
import java.util.List;

public class OlympicMedal extends Medal{
    public OlympicMedal(String name, String meterial){
        super(name, meterial);
    }

    /**
     * 具体的奖牌产品展示函数.
     */
    public void makeMedal(){
        System.out.println("\nclassname: (OlympicMedal) method: (makeMedal) action: (抽象工厂模式的具体零件类展示奥运奖牌的奖牌部分) ");
        List<String> medalDisplayBlock = new ArrayList<String>();
        medalDisplayBlock.add("奖牌部分展示");
        medalDisplayBlock.add("这块奖牌的名字是："+name);
        medalDisplayBlock.add("这块奖牌的材料是："+meterial);
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(medalDisplayBlock,true);
    }
}
