package olympic.main.postgame.awardceremony;

import olympic.main.postgame.awardceremony.prototypeframework.Manager;
import olympic.main.postgame.awardceremony.prototypeframework.MedalProduct;
import olympic.picture.OutputPicture;

/**
 * 颁发奖牌的Client类
 */
public class MedalPresenting {

    /**
     * 构造函数
     *
     * @param manager          管理奖牌原型的Manager.
     * @param titleGoldMedal   金牌获得者、团队名称.
     * @param titleSilverMedal 银牌获得者、团队名称.
     * @param titleBronzeMedal 铜牌获得者、团队名称.
     */
    public MedalPresenting(Manager manager, String titleGoldMedal, String titleSilverMedal, String titleBronzeMedal) {

        OutputPicture.printPictureOf(15);

        BronzeMedalPattern bmp = new BronzeMedalPattern();
        manager.register("B", bmp);
        MedalProduct productBronzeMedal = manager.create("B");
        OutputPicture.printPictureOf(6);
        productBronzeMedal.use(titleBronzeMedal);

        SilverMedalPattern smp = new SilverMedalPattern();
        manager.register("S", smp);
        MedalProduct productSilverMedal = manager.create("S");
        OutputPicture.printPictureOf(5);
        productSilverMedal.use(titleSilverMedal);

        GoldMedalPattern gmp = new GoldMedalPattern();
        manager.register("G", gmp);
        MedalProduct productGoldMedal = manager.create("G");
        OutputPicture.printPictureOf(4);
        productGoldMedal.use(titleGoldMedal);
    }

}
