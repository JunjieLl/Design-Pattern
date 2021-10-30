package olympic.main.game.pingponggame;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;


/**
 * 管道的阀门
 * 可以实例化为 乒乓球男单预赛、乒乓球男单复赛、乒乓球男单决赛
 */
public class PingpongFilter {
    private String name;
//    private String lastGameName;

    private List<Athlete> athletes;

    private List<PingpongGame> games = new ArrayList<>();

    private PingpongFilter nextFliter;

    public PingpongFilter(String name) {
        this.name = name;
    }

    public void setNextFliter(PingpongFilter nextFliter) {
        this.nextFliter = nextFliter;
    }

    private void addGame(){
        for (int i=0;i<athletes.size()/2;i++){
            PingpongGame game = new PingpongGame(this.name);
            game.addAthlete(athletes.get(2*i));
            game.addAthlete(athletes.get(2*i+1));
            games.add(game);
        }
    }

    public void setAthletes(List<Athlete> athletes){
        this.athletes = athletes;
        addGame();
    }

    public void start() {
        System.out.println("【"+name+"开始了!"+"】\n");
        for (PingpongGame game : games) {
            System.out.println(  "【"+name+"第"+(games.indexOf(game)+1)+"场】开始了");
            game.start();
        }
        if (nextFliter != null) {
            List<Athlete> nextFilterAthletes = new ArrayList<>();
            for (Athlete athlete : athletes) {
                if (athlete.getRank(name) == 1) {   //上一场获胜的运动员
                    nextFilterAthletes.add(athlete);
                }
            }
            nextFliter.setAthletes(nextFilterAthletes);
            nextFliter.start();
        }
    }
}
