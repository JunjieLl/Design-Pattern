package olympic.scene;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.pingponggame.Mode;
import olympic.main.game.pingponggame.PingpongPipeline;
import java.util.Scanner;

public class PingpongGameScene implements Scene{


    @Override
    public void play() {
        PreCompetitionSystemFacade pre = new PreCompetitionSystemFacade();

        System.out.println("【乒乓球Scene】请选择是否展示细节，输入true展示细节，输入其他不展示");
        Scanner input=new Scanner(System.in);
        //接受String类型
        Mode.setShowDetail(input.next().equals("true"));

        PingpongPipeline gameIndividual = new PingpongPipeline("乒乓球单人赛",pre.preCompetitionSystemFacade("Pingpong"));
        gameIndividual.start();

        PingpongPipeline gameTeam = new PingpongPipeline("乒乓球混双",pre.preCompetitionSystemFacade("PingpongTeam"));
        gameTeam.start();

    }
}
