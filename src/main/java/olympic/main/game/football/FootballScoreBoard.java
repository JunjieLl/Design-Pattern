package olympic.main.game.football;

/**小组赛积分榜
 * Observer模式
 * Singleton模式
 */
public class FootballScoreBoard implements Observer {

    /**
     * 单例实例
     */
    private static FootballScoreBoard singleton = new FootballScoreBoard();

    /**
     * 积分表
     */
    private int[] score;

    /**
     * 净胜球表
     */
    private int[] goalDifference;

    /**
     * 进球数表
     */
    private int[] goal;

    /**
     * 获取单例实例
     * @return singleton
     */
    public static FootballScoreBoard getInstance() {
        return singleton;
    }

    /**
     * 单例类，构造函数私有
     */
    private FootballScoreBoard() {
        this.score = new int[16];
        this.goalDifference = new int[16];
        this.goal = new int[16];
        for (int i = 0; i < 12; ++i) {
            score[i] = goalDifference[i] = goal[i] = 0;
        }
    }

    /**
     * 根据比赛结果更新积分榜
     *
     * @param game 完成的比赛
     */
    @Override
    public void update(FootballMatch game) {
        int score1 = game.getScore1(), score2 = game.getScore2();
        int id1 = game.getTeam1().getId(), id2 = game.getTeam2().getId();
        if (score1 > score2) {
            // Team1胜，积3分
            score[id1] += 3;
        } else if (score1 == score2) {
            // 平局，各积1分
            score[id1]++;
            score[id2]++;
        } else {
            // Team2胜，积3分
            score[id2] += 3;
        }

        this.goalDifference[id1] += score1 - score2;
        this.goalDifference[id2] += score2 - score1;
        this.goal[id1] += score1;
        this.goal[id2] += score2;
    }

    /**
     * 获取各球队的积分
     * @return 积分表
     */
    public int[] getScore() {
        return score;
    }

    /**
     * 获取各球队的净胜球
     * @return 净胜球表
     */
    public int[] getGoalDifference() {
        return goalDifference;
    }

    /**
     * 获取各球队的进球数
     * @return 进球数表
     */
    public int[] getGoal() {
        return goal;
    }
}
