package olympic.main.game.track;

import olympic.utils.PrintBlockFormat;
import olympic.main.person.athlete.Athlete;

import java.util.Collections;
import java.util.List;

/**
 * 使用了桥接模式,作为桥接模式的具体实现者
 * SemiFinals是半决赛
 */
public class SemiFinals  extends ContestImpl{
    /**
     *SemiFinals构造方法
     * @param athletes 运动员列表
     */
    SemiFinals(List<Athlete> athletes) {
        super(athletes);
        gameType="半决赛";
    }

    /**
     * 对场上的运动员成绩做一个比较
     * @param runners 比赛场上运动员们
     * @param group 第几场小组赛
     */
    private void rank(List<Athlete> runners,int group){
        int size = runners.size();
        PrintBlockFormat.getPrintFormat().addString("");
        PrintBlockFormat.getPrintFormat().addString("Group " + (group + 1) );

        PrintBlockFormat.getPrintFormat().addString(String.format("排名\t%-20s\t晋级\t","姓名"));

        Collections.shuffle(runners);
        for (int i = 0; i < size; i++) {
            if (i >= 4) {
                PrintBlockFormat.getPrintFormat().addString(String.format(i + 1 + "\t\t%-20s" + "\t" + "否" + "\t",runners.get(i).getName()));

                this.athletes.remove(runners.get(i));

            } else {
                PrintBlockFormat.getPrintFormat().addString(String.format(i + 1 + "\t\t%-20s" + "\t" + "是" + "\t",runners.get(i).getName()));

            }

        }
    }

    /**
     * 得到初赛的成果
     */
    public  void getResult(){
        List<List<Athlete>> runners=group();
        int size=runners.size();
        System.out.println(gameType+"一共有"+size+"场");
        PrintBlockFormat.getPrintFormat().addString("半决赛排名榜");
        for(int i=0;i<size;i++){
            rank(runners.get(i),i);
        }
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);

    }
}
