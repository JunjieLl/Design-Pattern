package olympic.main.postgame.award_ceremony;

import olympic.main.postgame.award_ceremony.factory.*;

public class MedalMaking {
    /**
     * 装饰奖牌的类.
     */
    public MedalMaking() {
        Factory factory = Factory.getFactory("olympic.main.postgame.award_ceremony.olympic_medal_factory.OlympicMedalFactory");
        Medal goldMedal = factory.createMedal("奥运金牌", "金1.35%、银92.5%、铜6.15%");
        Medal silverMedal = factory.createMedal("奥运银牌", "银100%");
        Medal bronzeMedal = factory.createMedal("奥运铜牌", "铜97%、锌2.5%、锡0.5%");

        Ribbon goldRibbon = factory.createRibbon("金彩祥云丝绸带", "金色");
        Ribbon silverRibbon = factory.createRibbon("银灰图腾尼龙带", "银色");
        Ribbon bronzeRibbon = factory.createRibbon("铜光华表麻布带", "黄铜色");

        EndProduct goldMedalEndProduct = factory.createEndProduct("配金色缎带的奥运金牌");
        EndProduct silverMedalEndProduct = factory.createEndProduct("配银色缎带的奥运银牌");
        EndProduct bronzeMedalEndProduct = factory.createEndProduct("配黄铜色缎带的奥运铜牌");

        goldMedalEndProduct.add(goldMedal);
        goldMedalEndProduct.add(goldRibbon);

        silverMedalEndProduct.add(silverMedal);
        silverMedalEndProduct.add(silverRibbon);

        bronzeMedalEndProduct.add(bronzeMedal);
        bronzeMedalEndProduct.add(bronzeRibbon);

        goldMedalEndProduct.present();
        silverMedalEndProduct.present();
        bronzeMedalEndProduct.present();
    }


}
