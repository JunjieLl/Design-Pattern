package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用了桥接模式,作为桥接模式的实现者
 * ContestImpl是比赛的抽象类
 */
public abstract class ContestImpl {
    public Athlete[] athletes;
    public String gameType;

    ContestImpl(Athlete[] athletes){
        this.athletes=athletes;

    }

    /**
     * 比赛开始，被contest调用
     */
    public  void start(){
        System.out.println(gameType+"开始");
    }

    /**
     * 取得比赛成果，被contset调用
     */
    public abstract void getResult();

    /**
     * 分组，每组最多8人,
     */
    public List<List<Athlete>> group(){
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


}
