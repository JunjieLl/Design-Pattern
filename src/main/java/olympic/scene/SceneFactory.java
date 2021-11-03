package main.java.olympic.scene;

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

    public olympic.scene.Scene getScene(String name) {
        switch (name) {
            case "Relays":
            case "Marathon":
            case "Sprints":
            case "Hurdling":
            case "Breaststroke":
            case "Freestyle":
            case "Backstroke":
            case "Butterflystroke":
                return new olympic.scene.TrackGameScene(name);
            case "Pingpong":
            case "PingpongTeam":
                return new olympic.scene.PingpongGameScene(name);
            case "FootballTeam":
                return new olympic.scene.FootballScene();
            default:
                return null;
        }
    }
}
