package olympic.main.person.athlete.pingong.Strategy;

import olympic.main.game.pingponggame.Mode;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.pingong.CallBack;
import olympic.main.person.athlete.pingong.PingpongAthlete;
import olympic.main.person.athlete.pingong.PlayPingpong;

import java.util.Random;

public class PingpongOffenseStrategy implements Strategy {

    private Athlete ownerAthlete;

    private Random random = new Random();

    private Integer ballState;

    private Boolean offense;

    private Integer offenseProb = 70;


    @Override
    public Boolean playWith(Athlete oppoent){
        if (Mode.getShowDetail()) {
            System.out.println("classname: (PingpongOffenseStrategy) method: (playWith) action: (策略模式中选手运用攻击策略) ");
        }
        ballState = random.nextInt(100);
        offense = random.nextInt(100)< offenseProb;
        if (ballState< ((PlayPingpong)ownerAthlete).getCapacity()){
            if (Mode.getShowDetail()) {
                System.out.println(ownerAthlete.getName() + " 击球" + (offense ? " 进攻" : " 防守"));
            }
            return !((CallBack)oppoent).call(ownerAthlete);
        }else{
            if (Mode.getShowDetail()) {
                System.out.println(ownerAthlete.getName() + " 接球失败");
            }
            return false;
        }
    }

    @Override
    public void setOwnerAthlete(Athlete ownerAthlete) {
        this.ownerAthlete = ownerAthlete;
    }



}