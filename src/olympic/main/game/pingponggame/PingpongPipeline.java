package olympic.main.game.pingponggame;

import olympic.main.game.Game;
import olympic.main.game.track.Contest;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.pingong.PingpongAthlete;

import java.util.ArrayList;
import java.util.List;

public class PingpongPipeline extends Game {
    private PingpongFilter firstGame;
    private PingpongFilter lastGame;

    public PingpongPipeline(List<Athlete> athleteList) {
        super(athleteList);
//        Double temp = Math.log(athleteList.size())/Math.log(2);
//        Integer filterNum = temp.intValue();
        if (athleteList.size() == 32){
            addFilter(new PingpongFilter("32进16"));
        }
        addFilter(new PingpongFilter("16进8"));
        addFilter(new PingpongFilter("四分之一决赛"));
        addFilter(new PingpongFilter("半决赛"));
        addFilter(new PingpongFilter("决赛"));
        firstGame.setAthletes(athletes);
    }

    public void addFilter(PingpongFilter filter) {
        if (firstGame == null){
            firstGame = filter;
            lastGame = filter;
        }else{
            lastGame.setNextFliter(filter);
            lastGame = filter;
        }
    }

    @Override
    public void start() {
        firstGame.start();
    }
}
