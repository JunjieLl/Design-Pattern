package olympic.main.game.basketball;

/**小组赛积分榜
 * Observer模式
 * Singleton模式
 */
public class BasketballScoreBoard implements Observer {

    private static BasketballScoreBoard singleton = new BasketballScoreBoard();
    private int[] score;
    private int[] gain;
    private int[] loss;

    /**
     * 获取单例实例
     * @return singleton
     */
    public static BasketballScoreBoard getInstance() {
        return singleton;
    }

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

    public int[] getScore() {
        return score;
    }

    public int[] getGain() {
        return gain;
    }

    public int[] getLoss() {
        return loss;
    }
}
