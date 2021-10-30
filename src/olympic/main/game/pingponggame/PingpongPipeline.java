package olympic.main.game.pingponggame;

import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 粒度最大的比赛类（比赛流水线，包括预赛复赛决赛）
 * 例如这个类可以实例化为乒乓球男单比赛
 */
public class PingpongPipeline extends Game {

    private PingpongFilter firstGame;
    private PingpongFilter lastGame;

    public PingpongPipeline(String name, List<Athlete> athleteList) {
        super(name, athleteList);
//        Double temp = Math.log(athleteList.size())/Math.log(2);
//        Integer filterNum = temp.intValue();
        if (athleteList.size() == 32) {
            addFilter(new PingpongFilter("32进16"));
        }
        addFilter(new PingpongFilter("16进8"));
        addFilter(new PingpongFilter("四分之一决赛"));
        addFilter(new PingpongFilter("半决赛"));
        addFilter(new PingpongFilter("决赛"));
        firstGame.setAthletes(athletes);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addFilter(PingpongFilter filter) {
        if (firstGame == null) {
            firstGame = filter;
            lastGame = filter;
        } else {
            lastGame.setNextFliter(filter);
            lastGame = filter;
        }
    }

    @Override
    public void start() {
        System.out.println("【" + name + "开始】");
        firstGame.start();
        System.out.println("【" + name + "结果】");
        for (Athlete athlete : athletes) {
            if (athlete.getRank("决赛") == 1) {
                System.out.println("冠军 " + athlete.getName());
                break;
            }
        }
        for (Athlete athlete : athletes) {
            if (athlete.getRank("决赛") == 2) {
                System.out.println("亚军 " + athlete.getName());
                break;
            }
        }
        System.out.print("季军 ");
        for (Athlete athlete : athletes) {
            if (athlete.getRank("半决赛") == 2) {
                System.out.print(athlete.getName() + " ");
            }
        }
        System.out.println("");
    }
}
