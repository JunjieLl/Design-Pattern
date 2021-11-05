package olympic.main.postgame.awardceremony;

import olympic.utils.PrintBlockFormat;
import olympic.main.postgame.awardceremony.medaldecorator.*;
import olympic.main.postgame.awardceremony.prototypeframework.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 金牌样式的产品
 */
public class GoldMedalPattern implements MedalProduct {

    /**
     * 构造金牌产品样式
     */
    public GoldMedalPattern() {
        System.out.println("\nclassname: (GoldMedalPattern) method: (GoldMedalPattern) action: (原型模式复刻金牌的样式生成刻字奖牌) \n");
        List<String> goldDisplayBlock = new ArrayList<>();
        goldDisplayBlock.add("颁发金牌");
        goldDisplayBlock.add("这块金色的奖牌上镌刻着比赛中取得第一名选手的名字和代表队。");
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(goldDisplayBlock, true);
    }

    /**
     * 使用金牌原型
     *
     * @param s 显示在金牌上的内容
     */
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

    /**
     * @return 一个金牌原型的克隆
     */
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
