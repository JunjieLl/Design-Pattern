package olympic.main.game.track;

import olympic.Utils.PrintBlockFormat;


import olympic.main.person.athlete.Athlete;

import java.util.Collections;
import java.util.List;

/**
 * 使用了桥接模式,作为桥接模式的具体实现者
 * Final是决赛，如果没有多次比赛就作为第一次
 */
public class Final extends ContestImpl {
    /**
     * Final构造方法
     *
     * @param athletes 运动员列表
     */
    public Final(List<Athlete> athletes) {
        super(athletes);
        gameType = "决赛";
    }

    /**
     * 对场上的运动员成绩做一个比较
     *
     * @param runners 比赛场上运动员们
     */
    private void rank(List<Athlete> runners) {
        int size = runners.size();
//        RandomDrawLots drawLots = new RandomDrawLots(runners, new PaperDrawLotsImpl(), 1);
//        runners = drawLots.randomDrawLots();
        PrintBlockFormat.getPrintFormat().addString("决赛排名榜");
        System.out.println("【决赛排名榜】");
        PrintBlockFormat.getPrintFormat().addString(String.format("排名\t\t%-20s\t", "姓名"));

        Collections.shuffle(runners);
        for (int i = 0; i < size; i++) {
            PrintBlockFormat.getPrintFormat().addString(String.format( "%-2s\t\t%-19s" + "\t" , i + 1,runners.get(i).getName()));
        }
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);
    }



    /**
     * 得到决赛的成果
     */
    public void getResult() {
        rank(athletes);

    }
}
