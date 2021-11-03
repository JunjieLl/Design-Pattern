package olympic.main.postgame.award_ceremony;

import olympic.main.postgame.award_ceremony.medal_decorator.*;
import olympic.main.postgame.award_ceremony.prototype_framework.*;

public class GoldMedalPattern implements MedalProduct {
    public GoldMedalPattern(){
        System.out.println("\nclassname: (GoldMedalPattern) method: (GoldMedalPattern) action: (生成金牌的原型) ");
        System.out.println("=====奥林匹克运动会金牌=====");
    }
    public void use(String s) {

        TitleDisplay td = new TitleDisplay();
        td.add("TONGJI 2021");
        td.add("GOLD   ");
        td.add(s);
        Display medalPattern =
                new FullBorder(
                        new SideBorder(
                                new FullBorder(
                                        new UpDownBorder(
                                                new SideBorder(
                                                        new UpDownBorder(
                                                                new SideBorder(
                                                                        td, '*'
                                                                ),
                                                                '='
                                                        ),
                                                        '|'
                                                ),
                                                '/'
                                        )
                                ),
                                '@')
                );
        System.out.println("\033[1;33m");
        medalPattern.show();
        System.out.println("\033[0m \n");
    }

    public MedalProduct createClone(){
        MedalProduct p = null;
        try{
            p = (MedalProduct) clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return p;
    }
}
