package olympic.main.game.volleyball;

/**小组赛积分榜
 * Observer模式
 * Singleton模式
 */
public class VolleyballScoreBoard implements Observer {

    private static VolleyballScoreBoard singleton = new VolleyballScoreBoard();
    private int[] score;
    private int[] win;
    private int[] gain;
    private int[] loss;

    /**
     * 获取单例实例
     * @return singleton
     */
    public static VolleyballScoreBoard getInstance() {
        return singleton;
    }

    private VolleyballScoreBoard() {
        this.score = new int[12];
        this.win = new int[12];
        this.gain = new int[12];
        this.loss = new int[12];
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

    public int[] getWin() {
        return win;
    }
}
