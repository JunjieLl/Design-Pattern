package olympic.main.game.basketball;

/**小组赛积分榜
 * Observer模式
 * Singleton模式
 */
public class BasketballScoreBoard implements Observer {

    /**
     * 单例实例
     */
    private static BasketballScoreBoard singleton = new BasketballScoreBoard();

    /**
     * 积分表
     */
    private int[] score;

    /**
     * 得分
     */
    private int[] gain;

    /**
     * 失分
     */
    private int[] loss;

    /**
     * 获取单例实例
     * @return singleton
     */
    public static BasketballScoreBoard getInstance() {
        return singleton;
    }

    /**
     * 单例类，构造函数私有
     */
    private BasketballScoreBoard() {
        this.score = new int[12];
        this.gain = new int[12];
        this.loss = new int[12];
        for (int i = 0; i < 12; ++i) {
            score[i] = gain[i] = loss[i] = 0;
        }
    }

    /**
     * 根据比赛结果更新积分榜
     *
     * @param game 完成的比赛
     */
    @Override
    public void update(BasketballMatch game) {
        int score1 = game.getScore1(), score2 = game.getScore2();
        int id1 = game.getTeam1().getId(), id2 = game.getTeam2().getId();
        if (score1 > score2) {
            // Team1胜，积3分
            score[id1] += 2;
            score[id2]++;
        } else {
            score[id2] += 2;
            score[id1]++;
        }

        this.gain[id1] += score1;
        this.gain[id2] += score2;
        this.loss[id1] += score2;
        this.loss[id2] += score1;
    }

    /**
     * 获取各球队积分表
     * @return 积分表
     */
    public int[] getScore() {
        return score;
    }

    /**
     * 获取各球队得分表
     * @return 得分表
     */
    public int[] getGain() {
        return gain;
    }

    /**
     * 获取各球队失分表
     * @return 失分表
     */
    public int[] getLoss() {
        return loss;
    }
}
