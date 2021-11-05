package olympic.main.game.basketball;

import olympic.utils.PrintBlockFormat;
import olympic.main.game.AbstractPipeline;
import olympic.main.game.Valve;
import olympic.main.game.basketball.round.Round;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.basketballathlete.BasketballTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton模式
 * Pipeline模式
 */
public class BasketballGameManager implements AbstractPipeline {
    /**
     * 单例实例
     */
    private static final BasketballGameManager singleton = new BasketballGameManager();

    /**
     * 前三名球队
     */
    private final ArrayList<Athlete> topThreeAthletes = new ArrayList<>();

    /**
     * 获取单例实例
     * @return 单例实例
     */
    public static BasketballGameManager getInstance() {
        return singleton;
    }

    /**
     * 单例类，构造函数私有
     */
    private BasketballGameManager() {
    }

    /**
     * 本轮的参赛球队
     */
    private final List<BasketballTeam> teams = new ArrayList<>();

    /**
     * 第一轮比赛，即管道模式的第一段管道
     */
    private Round first = null;

    /**
     * 获取第一轮比赛，即管道模式的第一段管道
     * @return 第一轮比赛
     */
    public Round getFirst() {
        return this.first;
    }

    /**
     * 设置第一轮比赛，即管道模式的第一段管道
     * @param first 第一轮比赛
     * @return 第一轮比赛
     */
    public Round setFirst(Round first) {
        this.first = first;
        return this.first;
    }

    /**
     * 传入所有参赛球队
     *
     * @param teams 所有参赛球队的列表
     */
    public void setTeams(List<Athlete> teams) {
        for (int i = 0; i < 12; ++i) {
            this.teams.add((BasketballTeam) (teams.get(i)));
        }
    }

    /**
     * 向管道末尾添加比赛
     * @param newGame 要添加的比赛
     */
    @Override
    public void addContest(Valve newGame) {
        Round r = this.first;
        while (r.getNext() != null) {
            r = r.getNext();
        }
        r.setNext(newGame);
    }

    /**
     * 依次进行所有轮次的比赛
     */
    public void start() {
        System.out.println("\nclassname: (BasketballGameManager) method: (play) action: (进行篮球比赛，使用了Pipeline模式以及Singleton模式) ");
        Round r = this.first;
        List<BasketballTeam> advancedTeams = teams;
        for (BasketballTeam advancedTeam : advancedTeams) {
            advancedTeam.setRank("BasketballTeam", 12);
        }
        int rank = 8;
        while (r != null) {
            // 为每支球队写入排名，晋级后更新排名
            r.setTeams(advancedTeams);
            r.start();
            advancedTeams = r.getAdvancedTeams();
            for (BasketballTeam advancedTeam : advancedTeams) {
                advancedTeam.setRank("BasketballTeam", rank);
            }
            rank /= 2;
            r = r.getNext();
        }

        advancedTeams.get(0).setRank("BasketballTeam", 1);

        topThreeAthletes.add(null);
        topThreeAthletes.add(null);
        topThreeAthletes.add(null);

        ArrayList<BasketballTeam> tmp = new ArrayList<>();  // 需要打季军赛的2支球队

        for (BasketballTeam team : teams) {
            int k = team.getRank("BasketballTeam");
            if (k == 4) {
                tmp.add(team);
            } else if (k < 4) {
                topThreeAthletes.set(k - 1, team);
            }
        }

        // 季军赛
        PrintBlockFormat.getPrintFormat().addString("季军赛");
        BasketballMatch thirdPlaceGame = new BasketballMatch(tmp.get(0), tmp.get(1));
        thirdPlaceGame.play();
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);

        if (thirdPlaceGame.getScore1() > thirdPlaceGame.getScore2()) {
            thirdPlaceGame.getTeam1().setRank("BasketballTeam", 3);
            topThreeAthletes.set(2, thirdPlaceGame.getTeam1());
        } else {
            thirdPlaceGame.getTeam2().setRank("BasketballTeam", 3);
            topThreeAthletes.set(2, thirdPlaceGame.getTeam2());
        }
    }

    /**
     * 获取前三名球队名单，用于后续颁发奖牌
     * @return 前三名球队列表
     */
    public ArrayList<Athlete> getTopThreeAthletes() {
        return topThreeAthletes;
    }
}
