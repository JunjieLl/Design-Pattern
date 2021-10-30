package olympic.scene;

import olympic.main.game.diving.ContestPipeline;
import olympic.main.game.track.Marathon;
import olympic.main.game.track.Relays;
import olympic.main.game.track.Sprints;
import olympic.main.game.track.TrackGame;
import olympic.main.person.PersonFactory;

public class TrackGameScene implements Scene{
    public TrackGameScene(String game){
        this.game=game;
    }
    String game;
    @Override
    public void play(){
        TrackGame track;
        switch (game){
            case "Relays":
                 track=new Relays(PersonFactory.getInstance().getAthletes("Relays"));
                break;
            case "Marathon":
                 track=new Marathon(PersonFactory.getInstance().getAthletes("Relays"));
                break;
            case "Sprints":
                 track=new Sprints(PersonFactory.getInstance().getAthletes("Relays"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + game);
        }
        track.start();
    }
}
