package olympic.scene;

import olympic.main.precompetitionsystem.PreCompetitionSystemFacade;
import olympic.main.director.Mode;
import olympic.main.game.badminton.BadmintonPipeline;

import java.util.Scanner;


/**
 * 羽毛球scene
 */
public class BadmintonGameScene implements Scene{
    /**
     * 构造函数
     * @param name 名字
     */
    public BadmintonGameScene(String name) {
        if (name.equals("Badminton")){
            badmintonPipeline = new BadmintonPipeline("羽毛球单人赛",
                    PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("Badminton"));
        } else {
            badmintonPipeline = new BadmintonPipeline("羽毛球混双",
                    PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("BadmintonTeam"));
        }
    }

    /**
     * 羽毛球pipeline
     */
    private BadmintonPipeline badmintonPipeline;

    /**
     * 运行场景
     */
    @Override
    public void play() {

        if (Mode.getNeedDetail()) {
            System.out.println("【BadmintonScene】请选择是否展示细节，输入true展示细节，输入其他不展示");
            Scanner input = new Scanner(System.in);
            //接受String类型
            Mode.setShowDetail(input.next().equals("true"));
        }
        badmintonPipeline.start();
        new CeremonyScene(badmintonPipeline.getTopThreeAthletes()).play();
    }
}
