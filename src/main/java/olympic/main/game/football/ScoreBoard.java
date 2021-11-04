package olympic.main.game.football;

/**小组赛积分榜
 * Observer模式
 * Singleton模式
 */
public class ScoreBoard implements Observer {

    private static ScoreBoard singleton = new ScoreBoard();
    private int[] score;
    private int[] goalDifference;
    private int[] goal;

    /**
     * 获取单例实例
     * @return singleton
     */
    public static ScoreBoard getInstance() {
        return singleton;
    }

    private ScoreBoard() {
        this.score = new int[16];
        this.goalDifference = new int[16];
        this.goal = new int[16];
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

    public int[] getScore() {
        return score;
    }

    public int[] getGoalDifference() {
        return goalDifference;
    }

    public int[] getGoal() {
        return goal;
    }
}
