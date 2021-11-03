package olympic.main.postgame.award_ceremony;

import olympic.main.postgame.award_ceremony.prototype_framework.Manager;
import olympic.main.postgame.award_ceremony.prototype_framework.MedalProduct;

public class MedalPresenting {
    private Manager manager;
    private String titleGoldMedal;
    private String titleSilverMedal;
    private String titleBronzeMedal;

    /**
     * @param manager          管理奖牌原型的Manager.
     * @param titleGoldMedal   金牌获得者、团队名称.
     * @param titleSilverMedal 银牌获得者、团队名称.
     * @param titleBronzeMedal 铜牌获得者、团队名称.
     */
    public MedalPresenting(Manager manager, String titleGoldMedal, String titleSilverMedal, String titleBronzeMedal) {
        this.manager = manager;
        this.titleGoldMedal = titleGoldMedal;
        this.titleSilverMedal = titleSilverMedal;
        this.titleBronzeMedal = titleBronzeMedal;

        BronzeMedalPattern bmp = new BronzeMedalPattern();
        manager.register("B", bmp);
        MedalProduct productBronzeMedal = manager.create("B");
        productBronzeMedal.use(titleBronzeMedal);

        SilverMedalPattern smp = new SilverMedalPattern();
        manager.register("S", smp);
        MedalProduct productSilverMedal = manager.create("S");
        productSilverMedal.use(titleSilverMedal);

        GoldMedalPattern gmp = new GoldMedalPattern();
        manager.register("G", gmp);
        MedalProduct productGoldMedal = manager.create("G");
        productGoldMedal.use(titleGoldMedal);
    }

}
