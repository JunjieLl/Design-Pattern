package olympic.main.postgame.award_ceremony.olympic_medal_factory;
import olympic.main.postgame.award_ceremony.factory.*;

public class OlympicMedalFactory extends Factory {
    /**
     * @param name     奖牌部分的名字.
     * @param material 奖牌部分的材料.
     * @return 具体的奖牌部分实例.
     */
    @Override
    public Medal createMedal(String name, String material){
        return new OlympicMedal(name, material);
    }

    /**
     * @param name  缎带部分的名字.
     * @param color 缎带的颜色.
     * @return 具体的缎带.
     */
    @Override
    public Ribbon createRibbon(String name, String color){
        return new OlympicRibbon(name, color);
    }

    /**
     * @param name 奖牌产品的名字.
     * @return 对应的具体金牌产品.
     */
    @Override
    public EndProduct createEndProduct(String name){
        return new OlympicMedalEndProduct(name);
    }
}
