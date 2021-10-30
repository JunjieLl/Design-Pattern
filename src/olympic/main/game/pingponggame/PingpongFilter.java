package olympic.main.game.pingponggame;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

public class PingpongFilter {
    private String name;
//    private String lastGameName;

    private List<Athlete> athletes;

    private List<PingpongGame> games;

    private PingpongFilter nextFliter;

    public PingpongFilter(String name) {
        this.name = name;
    }

    public void setNextFliter(PingpongFilter nextFliter) {
        this.nextFliter = nextFliter;
    }
//
//    public PingpongFilter(String name, String lastGameName) {
//        this.name = name;
//        this.lastGameName = lastGameName;
//    }


    private void addGame(){
        for (int i=0;i<athletes.size()/2;i++){
            PingpongGame game = new PingpongGame();
            game.setName(this.name);
            game.addAthlete(athletes.get(2*i));
            game.addAthlete(athletes.get(2*i+1));
        }
    }

//    public void setAthletes(List<Athlete> athletes) {
//        if (this.lastGameName == null){
//            this.athletes = athletes;
//        }else{
//            for (Athlete athlete:athletes){
//                if (athlete.getRank(lastGameName)==0){   //上一场获胜的运动员
//                    this.athletes.add(athlete);
//                }
//            }
//        }
//        addGame();
//    }

    public void setAthletes(List<Athlete> athletes){
        this.athletes = athletes;
        addGame();
    }


    public void start() {
        for (PingpongGame game : games) {
            game.start();
        }
        if (nextFliter != null) {
            List<Athlete> nextFilterAthletes = new ArrayList<>();
            for (Athlete athlete : athletes) {
                if (athlete.getRank(name) == 0) {   //上一场获胜的运动员
                    nextFilterAthletes.add(athlete);
                }
            }
            nextFliter.setAthletes(nextFilterAthletes);
            nextFliter.start();
        }
    }
}
