package olympic.scene;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.track.Hurdling;
import olympic.main.game.track.Marathon;
import olympic.main.game.track.Relays;
import olympic.main.game.track.Sprints;

public class SceneFactory {
    private SceneFactory() {
    }

    ;

    private static SceneFactory instance;

    public static SceneFactory getInstance() {
        if (instance == null) {
            instance = new SceneFactory();
        }
        return instance;
    }

    public Scene getScene(String name) {
        switch (name) {
            case "Relays":
                return new TrackGameScene("Relays");
            case "Marathon":
                return new TrackGameScene("Marathon");
            case "Sprints":
                return new TrackGameScene("Sprints");
            case "Hurdling":
                return new TrackGameScene("Hurdling");
            case "Pingpong":
                return new PingpongGameScene("乒乓球单人赛");
            case "PingpongTeam":
                return new PingpongGameScene("乒乓球混双");
            case "Diving":
                return new DivingGameScene("单人三米");
            case "DivingTeam":
                return new DivingGameScene("双人三米");
            case "FootballTeam":
                return new FootballScene();

            default:
                return null;
        }
    }
}
