package olympic.main.game.volleyball;

/**小组赛积分榜
 * Observer模式
 * Singleton模式
 */
public class VolleyballScoreBoard implements Observer {

    /**
     * 单例实例
     */
    private static VolleyballScoreBoard singleton = new VolleyballScoreBoard();

    /**
     * 积分表
     */
    private int[] score;

    /**
     * 胜场数
     */
    private int[] win;

    /**
     * 胜局数
     */
    private int[] gain;

    /**
     * 负局数
     */
    private int[] loss;

    /**
     * 得分数
     */
    private int[] pointGain;

    /**
     * 失分数
     */
    private int[] pointLoss;

    /**
     * 获取单例实例
     * @return singleton
     */
    public static VolleyballScoreBoard getInstance() {
        return singleton;
    }

    /**
     * 单例类，构造函数私有
     */
    private VolleyballScoreBoard() {
        this.score = new int[12];
        this.win = new int[12];
        this.gain = new int[12];
        this.loss = new int[12];
        this.pointGain = new int[12];
        this.pointLoss = new int[12];
        for (int i = 0; i < 12; ++i) {
            score[i] = win[i] = gain[i] = loss[i] = 0;
        }
    }

    /**
     * 根据比赛结果更新积分榜
     *
     * @param game 完成的比赛
     */
    @Override
    public void update(VolleyballMatch game) {
        int score1 = game.getScore1(), score2 = game.getScore2();
        int point1 = game.getPoint1(), point2 = game.getPoint2();
        int id1 = game.getTeam1().getId(), id2 = game.getTeam2().getId();
        if (score1 > score2) {
            if (score2 == 0 || score2 == 1) {
                score[id1] += 3;   // 3-0或3-1获胜，得3分
            } else {
                score[id1] += 2;   // 3-2获胜，胜者得2分
                score[id2] += 1;   // 负者得1分
            }
            win[id1]++;
        } else {
            if (score1 == 0 || score1 == 1) {
                score[id2] += 3;   // 3-0或3-1获胜，得3分
            } else {
                score[id2] += 2;   // 3-2获胜，胜者得2分
                score[id1] += 1;   // 负者得1分
            }
            win[id2]++;
        }

        this.gain[id1] += score1;
        this.gain[id2] += score2;
        this.loss[id1] += score2;
        this.loss[id2] += score1;
        this.pointGain[id1] += point1;
        this.pointGain[id2] += point2;
        this.pointLoss[id1] += point2;
        this.pointLoss[id2] += point1;
    }

    /**
     * 获取各球队的积分
     * @return 积分表
     */
    public int[] getScore() {
        return score;
    }

    /**
     * 获取各球队的胜局数
     * @return 胜局数表
     */
    public int[] getGain() {
        return gain;
    }

    /**
     * 获取各球队的负局数
     * @return 负局数表
     */
    public int[] getLoss() {
        return loss;
    }

    /**
     * 获取各球队的胜场数
     * @return 胜场数表
     */
    public int[] getWin() {
        return win;
    }

    /**
     * 获取各球队的总得分
     * @return 总得分表
     */
    public int[] getPointGain() {
        return pointGain;
    }

    /**
     * 获取各球队的总失分
     * @return 总失分表
     */
    public int[] getPointLoss() {
        return pointLoss;
    }
}
