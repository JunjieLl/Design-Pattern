package olympic.scene;

import olympic.main.preCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.track.*;

/**
 * 田径比赛场景
 */
public class TrackGameScene implements Scene {
    /**
     * 田径比赛场景构造函数
     *
     * @param game 比赛名称
     */
    public TrackGameScene(String game) {
        this.game = game;
    }

    /**
     * 比赛名称
     */
    String game;

    /**
     * 场景开始
     */
    @Override
    public void play() {
        TrackGame track;
        switch (game) {
            case "Relays":
                track = new Relays(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
                break;
            case "Marathon":
                track = new Marathon(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
                break;
            case "Sprints":
                track = new Sprints(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
                break;
            case "Hurdling":
                track = new Hurdling(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
                break;

            case "Breaststroke":
                track = new Freestyle(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
                break;
            case "Freestyle":
                track = new Freestyle(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
                break;
            case "Backstroke":
                track = new Backstroke(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
                break;
            case "Butterflystroke":
                track = new Butterflystroke(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(game));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + game);
        }
        track.start();
        CeremonyScene ceremonyScene = new CeremonyScene(track.getAthletes());
        ceremonyScene.play();
    }
}
