package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用了桥接模式,作为桥接模式的实现者
 * ContestImpl是比赛的抽象类
 */
public abstract class ContestImpl {
    /**
     * 运动员列表
     */
    public List<Athlete> athletes;
    /**
     * 比赛类型，初赛，复赛或者决赛
     */
    public String gameType;
    /**
     * ContestImpl的构造方法
     * @param athletes 运动员列表
     */
    ContestImpl(List<Athlete> athletes){
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


        if(athletes.size()>8){
            int i=0;
            while(i<athletes.size()){
                List<Athlete> cols =  new  ArrayList<>();
                int  j =  0 ;
                while(j<8&&i+j<athletes.size()){
                    cols.add(athletes.get(i+j++));
                }
                i+=j;
                rows.add(cols);
            }

        }
        else{
            rows.add(athletes);
        }
        return rows;
    }


}
