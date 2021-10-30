package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.Collections;
import java.util.List;

/**
 * 使用了桥接模式,作为桥接模式的具体实现者
 * Final是决赛，如果没有多次比赛就作为第一次
 */
public class Final extends ContestImpl{
    Final(List<Athlete> athletes) {
        super(athletes);
        gameType="决赛";
    }

    /**
     * 对场上的运动员成绩做一个比较
     * @param runners 比赛场上运动员们
     */
    private void rank(List<Athlete> runners){
//        System.out.println("现在上场的运动员有：");
        int size=runners.size();
//        for(Athlete temp : runners){
//            System.out.print("目前没有他的名字"+temp+" ");
//        }
        System.out.println("【决赛排名榜】");
        System.out.println("排名\t姓名\t时间");
        Collections.shuffle(runners);
        for(int i=0;i<size;i++){
            System.out.println(i+1+"\t"+"姓名"+"\t"+"时间"+"\t");
        }
        System.out.println("\n");
    }

    /**
     * 得到初赛的成果
     */
    public  void getResult(){
        rank(athletes);
    }
}
