package olympic.main.game.football;

import java.util.ArrayList;

/**
 * Singleton模式
 * Pipeline模式 相当于Pipeline类
 */
public class FootballGameManager {
    private static FootballGameManager singleton = new FootballGameManager();

    public static FootballGameManager getInstance() {
        return singleton;
    }

    private ArrayList<FootballTeam> teams = new ArrayList<>();
    private Round first = null;

    public Round getFirst() {
        return this.first;
    }

    public Round setFirst(Round first) {
        this.first = first;
        return this.first;
    }

    public void start() {
        // 生成参赛名单
        for (int i = 0; i < 16; i++) {
            teams.add(new FootballTeam("Team" + i, i));
        }

        Round r = this.first;
        while (r != null) {
            teams = r.play(teams);
            r = r.getNext();
        }

        System.out.println("足球比赛冠军为" + teams.get(0).getNation());
    }
}
