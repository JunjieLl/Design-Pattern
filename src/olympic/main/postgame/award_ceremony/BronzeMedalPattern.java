package olympic.main.postgame.award_ceremony;

import olympic.main.postgame.award_ceremony.prototype_framework.*;
import olympic.main.postgame.award_ceremony.medal_decorator.*;

public class BronzeMedalPattern implements MedalProduct {
    public BronzeMedalPattern(){
        System.out.println("\nclassname: (BronzeMedalPattern) method: (BronzeMedalPattern) action: (生成铜牌的原型) ");
        System.out.println("=====奥林匹克运动会铜牌=====");
    }
    public void use(String s) {

        TitleDisplay td = new TitleDisplay();
        td.add("TONGJI 2021");
        td.add("BRONZE   ");
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
                                                                '+'
                                                        ),
                                                        '#'
                                                ),
                                                'B'
                                        )
                                ), 'O')
                );
        System.out.println("\033[1;31m");
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
