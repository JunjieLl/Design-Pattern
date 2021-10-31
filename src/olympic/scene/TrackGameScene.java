package olympic.scene;

import olympic.main.game.diving.ContestPipeline;
import olympic.main.game.track.*;
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
                 track=new Marathon(PersonFactory.getInstance().getAthletes("Marathon"));
                break;
            case "Sprints":
                 track=new Sprints(PersonFactory.getInstance().getAthletes("Sprints"));
                break;
            case "Hurdling":
                track=new Hurdling(PersonFactory.getInstance().getAthletes("Hurdling"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + game);
        }
        track.start();
    }
}
