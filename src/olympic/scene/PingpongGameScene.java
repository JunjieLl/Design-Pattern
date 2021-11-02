package olympic.scene;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.pingponggame.Mode;
import olympic.main.game.pingponggame.PingpongPipeline;
import java.util.Scanner;

public class PingpongGameScene implements Scene{
    public PingpongGameScene(String name) {
        if (name == "乒乓球单人赛"){
            pingpongPipeline = new PingpongPipeline("乒乓球单人赛",
                    PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("Pingpong"));
        }else{
            pingpongPipeline = new PingpongPipeline("乒乓球混双",
                    PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("PingpongTeam"));
        }
    }

    private PingpongPipeline pingpongPipeline;

    @Override
    public void play() {

        System.out.println("【乒乓球Scene】请选择是否展示细节，输入true展示细节，输入其他不展示");
        Scanner input=new Scanner(System.in);
        //接受String类型
        Mode.setShowDetail(input.next().equals("true"));

        pingpongPipeline.start();

    }
}
