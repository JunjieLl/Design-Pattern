package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 使用了桥接模式,作为桥接模式的具体实现者
 * Prelude是初赛
 */
public class Prelude extends ContestImpl{
    Prelude(Athlete[] athletes) {
        super(athletes);
    }

    public void start(){
        System.out.println("初赛开始了");

    }
    /**
     * 分组，每组最多8人,
     */
    private List<List<Athlete>> group(){
        List<List<Athlete>> rows =  new ArrayList<>();

        if(athletes.length>8){
            int i=0;
            while(i<athletes.length){
                List<Athlete> cols =  new  ArrayList<>();
                int  j =  0 ;
                while(j<8&&i+j<athletes.length){
                    cols.add(athletes[j++]);
                }
                i+=j;
                rows.add(cols);
            }

        }
        else{
            rows.add(Arrays.asList(athletes));
        }
        return rows;
    }

    /**
     * 对场上的运动员成绩做一个比较
     * @param runners 比赛场上运动员们
     */
    private void rank(List<Athlete> runners){
        System.out.println("现在上场的运动员有：");
        int size=runners.size();
        for(Athlete temp : runners){
            System.out.print("目前没有他的名字"+temp+" ");
        }
                Collections.shuffle(runners);
        for(int i=0;i<size;i++){

            if(i>=4){
                System.out.println("名字"+"获得了第"+i+"名"+"，很遗憾，没有进入半决赛");
            }else{
                System.out.println("名字"+"获得了第"+i+"名");
            }
        }
    }

    public  void getResult(){
        List<List<Athlete>> runners=group();
        int size=runners.size();
        System.out.println("初赛一共有"+size+"轮");
        for(int i=0;i<size;i++){
            System.out.println("第"+(i+1)+"场开始了");
            rank(runners.get(i));
        }

    }
}
