package olympic.main.game.track;

import main.java.olympic.scene.CeremonyScene;

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
        System.out.println("【决赛排名榜】");
        System.out.println("排名\t姓名\t");
        Collections.shuffle(runners);


        for (int i = 0; i < size; i++) {
            System.out.println(i + 1 + "\t" + runners.get(i).getName() + "\t");
        }


        System.out.println("\n");
    }

    /**
     * 得到决赛的成果
     */
    public void getResult() {
        rank(athletes);
        CeremonyScene ceremonyScene = new CeremonyScene(athletes);
        ceremonyScene.play();
    }
}
