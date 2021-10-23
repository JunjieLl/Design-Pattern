package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<List<Athlete>> rows =  new ArrayList();
        if(athletes.length>8){
            for  ( int  i =  0 ;i < athletes.length;i ++) {

                int  index = i * 8;
                List<Athlete> cols =  new  ArrayList();
                int  j =  0 ;
                while  (j < 8 && index < athletes.length) {
                    cols.add(athletes[athletes.length]);
                    j ++;
                }
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

    }


    public  void getResult(){


    }
}
