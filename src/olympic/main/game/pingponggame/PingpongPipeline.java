package olympic.main.game.pingponggame;

import olympic.main.game.AbstractPipeline;
import olympic.main.game.Game;
import olympic.main.game.Valve;
import olympic.main.person.athlete.Athlete;
import olympic.scene.CeremonyScene;

import java.util.ArrayList;
import java.util.List;

/**
 * 粒度最大的比赛类（比赛流水线，包括预赛复赛决赛）
 * 例如这个类可以实例化为乒乓球男单比赛
 */
public class PingpongPipeline implements AbstractPipeline {

    private PingpongFilter firstGame;
    private PingpongFilter lastGame;

    private String name;

    private List<Athlete> athletes;

    public PingpongPipeline(String name, List<Athlete> athleteList) {
        this.name = name;
        this.athletes = athleteList;

        if (athleteList.size() == 32) {
            addContest(new PingpongFilter("32进16"));
        }
        addContest(new PingpongFilter("16进8"));
        addContest(new PingpongFilter("四分之一决赛"));
        addContest(new PingpongFilter("半决赛"));
        addContest(new PingpongFilter("决赛"));
        firstGame.setAthletes(athletes);
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

//    public void addFilter(PingpongFilter filter) {
//        if (firstGame == null) {
//            firstGame = filter;
//            lastGame = filter;
//        } else {
//            lastGame.setNextFilter(filter);
//            lastGame = filter;
//        }
//    }

    /**
     * 季军赛
     */
    public void ThirdGame(){
        List<Athlete> thirdGameathletes = new ArrayList<>();
        for (Athlete athlete:athletes){
            if (athlete.getRank("半决赛") == 2){
                thirdGameAthletes.add(athlete);
            }
        }
        PingpongFilter thirdGame = new PingpongFilter("季军赛");
        thirdGame.setAthletes(thirdGameAthletes);
        thirdGame.start();
        for (Athlete athlete:athletes){
            if (athlete.getRank("季军赛") == 1){
                return athlete;
            }
        }
//        thirdGame
    }


    @Override
    public void addContest(Valve newGame) {
        if (firstGame == null) {
            firstGame =  (PingpongFilter)newGame;
            lastGame = firstGame;
        } else {
            lastGame.setNext(newGame);
            lastGame = (PingpongFilter)newGame;
        }
    }

    @Override
    public void start() {
        System.out.println("【"+name+"开始】");

        firstGame.start();  // 管道模式的开始比赛，实际上跑了整个比赛

        List<Athlete> topThreeAthletes = new ArrayList<>();

        // 打印比赛结果
        for (Athlete athlete:athletes){
            if (athlete.getRank("决赛") == 1){
                topThreeAthletes.add(athlete);
                break;
            }
        }
        for (Athlete athlete : athletes) {
            if (athlete.getRank("决赛") == 2) {
                topThreeAthletes.add(athlete);
                break;
            }
        }
        topThreeAthletes.add(thirdGame());
        new CeremonyScene(topThreeAthletes).play();
    }
}
