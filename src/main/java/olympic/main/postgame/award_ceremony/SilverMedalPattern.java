package olympic.main.postgame.award_ceremony;

import olympic.main.postgame.award_ceremony.prototype_framework.*;
import olympic.main.postgame.award_ceremony.medal_decorator.*;

public class SilverMedalPattern implements MedalProduct {
    public SilverMedalPattern() {
        System.out.println("\nclassname: (SilverMedalPattern) method: (SilverMedalPattern) action: (生成银牌的原型) ");
        System.out.println("=====奥林匹克运动会银牌=====");
    }

    public void use(String s) {
        TitleDisplay td = new TitleDisplay();
        td.add("TONGJI 2021");
        td.add("SILVER   ");
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
                                                                '-'
                                                        ),
                                                        '~'
                                                ),
                                                'S'
                                        )
                                ),
                                '$')
                );
        System.out.println("\033[1;37m");
        medalPattern.show();
        System.out.println("\033[0m \n");
    }

    public MedalProduct createClone() {
        MedalProduct p = null;
        try {
            p = (MedalProduct) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
