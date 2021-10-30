package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用Builder设计模式
 * 作为Director,使用Contest的API来生成实例，不依赖于什么比赛
 */
public class ContestDirector {
    public Integer rounds;
    List<Athlete> athletes;
    /**
     *
     * @param rounds 一共有几轮比赛
     * @param athletes 所有参加比赛的运动员
     */
    public ContestDirector(int rounds,List<Athlete>athletes){
        this.rounds=rounds;
        this.athletes=athletes;

    }

    public void construct(){
        System.out.println("classname: (ContestDirector) method: (construct) action: (Builder method模式中运动员参与比赛) ");
        if(rounds==1){
            Contest contest3=new Contest(new Final(athletes));
            contest3.display();
        }else if(rounds==2){
            Contest contest1=new Contest(new Prelude(athletes));
            contest1.display();
            Contest contest3=new Contest(new Final(athletes));

            contest3.display();
        }else{
            Contest contest1=new Contest(new Prelude(athletes));
            contest1.display();
            Contest contest2=new Contest(new SemiFinals(athletes));
            contest2.display();
            Contest contest3=new Contest(new Final(athletes));
            contest3.display();
        }



    }
}
