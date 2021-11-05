package olympic.main.director;


import olympic.picture.OutputPicture;
import olympic.scene.BadmintonGameScene;
import olympic.scene.FootballScene;
import olympic.scene.Scene;

final public class SceneFactory {
    private SceneFactory() {
    }

    public static final Scene getScene(String name) {
        switch (name) {
            case "Relays":
            case "Marathon":
            case "Sprints":
            case "Hurdling":
                OutputPicture.printPictureOf(14); //田径图片
            case "Breaststroke":
            case "Freestyle":
            case "Backstroke":
            case "Butterflystroke":
                return new olympic.scene.TrackGameScene(name);
            case "Pingpong":
            case "PingpongTeam":
                return new olympic.scene.PingpongGameScene(name);
            case "FootballTeam":
                return new FootballScene();
            case "Three-Meter-Board-Diving":
            case "Ten-Meter-Board-Diving":
            case "Three-Meter-Board-DivingTeam":
            case "Ten-Meter-Board-DivingTeam":
                return new olympic.scene.DivingGameScene(name);
            case "Badminton":
            case "BadmintonTeam":
                return new BadmintonGameScene(name);
            default:
                return null;
        }
    }
}
