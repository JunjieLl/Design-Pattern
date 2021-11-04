package olympic.main.postgame.award_ceremony;

import olympic.Utils.PrintBlockFormat;
import olympic.main.postgame.award_ceremony.prototype_framework.*;
import olympic.main.postgame.award_ceremony.medal_decorator.*;

import java.util.ArrayList;
import java.util.List;

public class SilverMedalPattern implements MedalProduct {
    public SilverMedalPattern(){
        System.out.println("\nclassname: (SilverMedalPattern) method: (SilverMedalPattern) action: (原型模式复刻银牌的样式生成刻字奖牌) \n");
        List<String> silverDisplayBlock = new ArrayList<>();
        silverDisplayBlock.add("颁发银牌");
        silverDisplayBlock.add("这块银色的奖牌上镌刻着比赛中取得第二名选手的名字和代表队。");
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(silverDisplayBlock,true);
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
