package olympic.main.postgame.award_ceremony;

import olympic.Utils.PrintBlockFormat;
import olympic.main.postgame.award_ceremony.prototype_framework.*;
import olympic.main.postgame.award_ceremony.medal_decorator.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 铜牌样式的产品
 */
public class BronzeMedalPattern implements MedalProduct {
    /**
     * 构造铜牌产品样式
     */
    public BronzeMedalPattern() {
        System.out.println("classname: (BronzeMedalPattern) method: (BronzeMedalPattern) action: (原型模式复刻铜牌的样式生成刻字奖牌) \n");
        List<String> bronzeDisplayBlock = new ArrayList<>();
        bronzeDisplayBlock.add("颁发铜牌");
        bronzeDisplayBlock.add("这块红色的奖牌上镌刻着比赛中取得第三名选手的名字和代表队。");
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(bronzeDisplayBlock, true);
    }

    /**
     * 使用铜牌原型
     *
     * @param s 显示在铜牌上的内容
     */
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

    /**
     * @return 一个铜牌原型的克隆
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