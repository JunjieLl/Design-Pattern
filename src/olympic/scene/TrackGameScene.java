package olympic.scene;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.track.*;

/**
 * 田径比赛场景
 */
public class TrackGameScene implements Scene{
    /**
     * 田径比赛场景构造函数
     * @param game 比赛名称
     */
    public TrackGameScene(String game){
        this.game=game;
    }

    /**
     * 比赛名称
     */
    String game;

    /**
     * 场景开始
     */
    @Override
    public void play(){
        TrackGame track;
        switch (game){
            case "Relays":
                 track=new Relays(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("Relays"));
                break;
            case "Marathon":
                 track=new Marathon(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("Marathon"));
                break;
            case "Sprints":
                 track=new Sprints(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("Sprints"));
                break;
            case "Hurdling":
                track=new Hurdling(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("Hurdling"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + game);
        }
        track.start();
    }
}
