package olympic.main.game.track;

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
        int size=runners.size();

        System.out.println("【半决赛赛排名榜】\nGroup "+(group+1)+"\n" +
                "排名\t姓名\t晋级\t");
        Collections.shuffle(runners);
        for(int i=0;i<size;i++){

            if(i>=4){
                System.out.println(i+1+"\t"+runners.get(i).getName()+"\t"+"否"+"\t");
                this.athletes.remove(runners.get(i));
            }else{
                System.out.println(i+1+"\t"+runners.get(i).getName()+"\t"+"是"+"\t");
            }
        }
        System.out.println("\n");
    }

    /**
     * 得到初赛的成果
     */
    public  void getResult(){
        List<List<Athlete>> runners=group();
        int size=runners.size();
        System.out.println(gameType+"一共有"+size+"场");
        for(int i=0;i<size;i++){
            System.out.println("第"+(i+1)+"场开始了");
            rank(runners.get(i),i);
        }

    }
}
