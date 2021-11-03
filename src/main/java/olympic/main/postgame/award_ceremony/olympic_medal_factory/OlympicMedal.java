package olympic.main.postgame.award_ceremony.olympic_medal_factory;
import olympic.main.postgame.award_ceremony.factory.*;

public class OlympicMedal extends Medal{
    public OlympicMedal(String name, String meterial){
        super(name, meterial);
    }

    /**
     * 具体的奖牌产品展示函数.
     */
    public void makeMedal(){
        System.out.println("\nclassname: (OlympicMedal) method: (makeMedal) action: (展示奥运奖牌的奖牌部分) ");
        System.out.println("这是奥运奖牌的制作过程...");
        System.out.println("这块奖牌的名字是："+name);
        System.out.println("这块奖牌的材料是："+meterial);
    }
}
