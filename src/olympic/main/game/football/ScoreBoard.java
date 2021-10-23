package olympic.main.game.football;

/**小组赛积分榜
 * 模式: Observer
 */
public class ScoreBoard implements Observer{

    private static ScoreBoard singleton = new ScoreBoard();
    private int[][] score;
    private int[][] goalDifference;
    private int[][] goal;

    public static ScoreBoard getInstance() {
        return singleton;
    }

    private ScoreBoard() {
        this.score = new int[4][4];
        this.goalDifference = new int[4][4];
        this.goal = new int[4][4];
    }
    @Override
    public void update(FootballGame game) {
        int score1 = game.getScore1(), score2 = game.getScore2();
        int group = game.getTeam1().getGroup();
        int id1 = game.getTeam1().getId(), id2 = game.getTeam2().getId();
        if (score1 > score2) {
            // Team1胜，积3分
            score[group][id1] += 3;
        }
        else if (score1 == score2) {
            // 平局，各积1分
            score[group][id1]++;
            score[group][id2]++;
        }
        else {
            // Team2胜，积3分
            score[group][id2] += 3;
        }

        this.goalDifference[group][id1] = score1 - score2;
        this.goalDifference[group][id2] = score2 - score1;
        this.goal[group][id1] = score1;
        this.goal[group][id2] = score2;
    }
}
