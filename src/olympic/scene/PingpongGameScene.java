package olympic.scene;

import olympic.main.game.pingponggame.Mode;
import olympic.main.game.pingponggame.PingpongPipeline;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.pingong.PingpongAthlete;
import olympic.main.person.athlete.pingong.PingpongTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PingpongGameScene implements Scene{


    @Override
    public void play() {
        PersonFactory.getInstance().springUtil();

        System.out.println("【乒乓球Scene】请选择是否展示细节，输入true展示细节，输入其他不展示");
        Scanner input=new Scanner(System.in);
        //接受String类型
        Mode.setShowDetail(input.next().equals("true"));

        PingpongPipeline gameIndividual = new PingpongPipeline("乒乓球单人赛",PersonFactory.getInstance().getAthletes("Pingpong"));
        PingpongPipeline gameTeam = new PingpongPipeline("乒乓球混双",PersonFactory.getInstance().getAthletes("PingpongTeam"));

        gameIndividual.start();
        gameTeam.start();
    }
}
