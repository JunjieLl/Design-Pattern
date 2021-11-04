package olympic.scene;



final public class SceneFactory {
    private SceneFactory() {
    }

    public static final Scene getScene(String name) {
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
                return new FootballScene();
            case "Three-Meter-Board-Diving":
            case "Ten-Meter-Board-Diving":
            case "Three-Meter-Board-DivingTeam":
            case "Ten-Meter-Board-DivingTeam":
                return new olympic.scene.DivingGameScene(name);



            default:
                return null;
        }
    }
}
