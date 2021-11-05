package olympic.main.game.badminton;

import olympic.main.drawlots.PaperDrawLotsImpl;
import olympic.main.drawlots.RandomDrawLots;
import olympic.main.game.Valve;
import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;


/**
 * 管道的阀门
 * 可以实例化为 乒乓球男单预赛、乒乓球男单复赛、乒乓球男单决赛
 */
public class BadmintonFilter extends Valve {

    /**
     * 包含的比赛
     * 比如预赛会有很多场比赛
     */
    private final List<BadmintonGame> games = new ArrayList<>();

    private BadmintonFilter nextFilter;

    public BadmintonFilter(String name) {
        this.name = name;
    }

    public void setAthletes(List<Athlete> athletes) {
        RandomDrawLots drawLots = new RandomDrawLots(athletes, new PaperDrawLotsImpl(), 2, true);
        this.athletes = drawLots.randomDrawLots();
        addGame();
    }

    private void addGame() {
        for (int i = 0; i < athletes.size() / 2; i++) {
            BadmintonGame game = new BadmintonGame(this.name);
            // 为比赛添加运动员
            game.addAthlete(athletes.get(2 * i));
            game.addAthlete(athletes.get(2 * i + 1));
            games.add(game);
        }
    }

    @Override
    public Valve setNext(Valve valve) {
        this.nextFilter = (BadmintonFilter) valve;
        return this;
    }

    /**
     * 对外接口，开始比赛
     */
    @Override
    public void start() {
        System.out.println("【" + name + "开始了!" + "】\n");
        for (BadmintonGame game : games) {
            System.out.println("【" + name + "第" + (games.indexOf(game) + 1) + "场】开始了");
            game.start();
        }

        // 过滤出晋级的运动员交给下一轮比赛
        if (nextFilter != null) {
            List<Athlete> nextFilterAthletes = new ArrayList<>();
            for (Athlete athlete : athletes) {
                if (athlete.getRank(name) == 1) {   //上一场获胜的运动员
                    nextFilterAthletes.add(athlete);
                }
            }
            nextFilter.setAthletes(nextFilterAthletes);
            nextFilter.start();
        }
    }
}
