package olympic.main.game.football;

import olympic.Utils.PrintBlockFormat;
import olympic.main.game.AbstractPipeline;
import olympic.main.game.Valve;
import olympic.main.game.football.round.Round;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton模式
 * Pipeline模式
 */
public class FootballGameManager implements AbstractPipeline {
    /**
     * 单例实例
     */
    private static final FootballGameManager singleton = new FootballGameManager();

    /**
     * 前三名球队
     */
    private final ArrayList<Athlete> topThreeAthletes = new ArrayList<>();

    /**
     * 获取单例类实例
     * @return 单例实例
     */
    public static FootballGameManager getInstance() {
        return singleton;
    }

    /**
     * 单例类，构造函数私有
     */
    private FootballGameManager() {
    }

    /**
     * 本轮参赛球队
     */
    private final List<FootballTeam> teams = new ArrayList<>();

    /**
     * 第一轮比赛，即管道模式的第一段管道
     */
    private Round first = null;



    /**
     * 设置第一轮比赛，即管道模式的第一段管道
     * @param first 第一段管道
     * @return 轮
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
        for (int i = 0; i < 16; ++i) {
            this.teams.add((FootballTeam) (teams.get(i)));
        }
    }

    /**
     * 向管道末尾添加比赛
     * @param newGame 比赛名
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
        System.out.println("\nclassname: (FootballGameManager) method: (play) action: (进行足球比赛，使用了Pipeline模式、Singleton模式以及Template Method模式) ");
        Round r = this.first;
        int rank = teams.size();
        List<FootballTeam> advancedTeams = teams;
        while (r != null) {
            // 为每支球队写入排名，晋级后更新排名
            for (FootballTeam advancedTeam : advancedTeams) {
                advancedTeam.setRank("FootballTeam", rank);
            }
            rank /= 2;
            r.setTeams(advancedTeams);
            r.start();
            advancedTeams = r.getAdvancedTeams();
            r = r.getNext();
        }

        advancedTeams.get(0).setRank("FootballTeam", rank);

        topThreeAthletes.add(null);
        topThreeAthletes.add(null);
        topThreeAthletes.add(null);

        ArrayList<FootballTeam> tmp = new ArrayList<>();  // 需要打季军赛的2支球队

        for (FootballTeam team : teams) {
            int k = team.getRank("FootballTeam");
            if (k == 4) {
                tmp.add(team);
            } else if (k < 4) {
                topThreeAthletes.set(k - 1, team);
            }
        }

        // 季军赛
        PrintBlockFormat.getPrintFormat().addString("季军赛");
        EliminationFootballMatch thirdPlaceGame = new EliminationFootballMatch(tmp.get(0), tmp.get(1));
        thirdPlaceGame.play();
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);

        if (thirdPlaceGame.getScore1() > thirdPlaceGame.getScore2()) {
            thirdPlaceGame.getTeam1().setRank("FootballTeam", 3);
            topThreeAthletes.set(2, thirdPlaceGame.getTeam1());
        } else if (thirdPlaceGame.getScore1() < thirdPlaceGame.getScore2()) {
            thirdPlaceGame.getTeam2().setRank("FootballTeam", 3);
            topThreeAthletes.set(2, thirdPlaceGame.getTeam2());
        } else if (thirdPlaceGame.getPenaltyScore1() > thirdPlaceGame.getPenaltyScore2()) {
            thirdPlaceGame.getTeam1().setRank("FootballTeam", 3);
            topThreeAthletes.set(2, thirdPlaceGame.getTeam1());
        } else {
            thirdPlaceGame.getTeam2().setRank("FootballTeam", 3);
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
