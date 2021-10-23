package olympic.main.game.football;

import olympic.main.game.ScheduleIterator;

import java.util.ArrayList;

/**
 * Singleton模式
 */
public class FootballGameManager {
    private final int nGroups = 4;
    private final int nTeams = 4;
    private static FootballGameManager singleton = new FootballGameManager();

    private FootballSchedule schedule = new FootballSchedule();
    public static FootballGameManager getInstance() {
        return singleton;
    }

    private FootballTeam teams[][] = new FootballTeam[4][4];

    public void start() {
        // 小组赛

        // 生成参赛名单
        for (int g = 0; g < nGroups; g++) {
            for (int i = 0; i < nTeams; i++) {
                teams[g][i] = new FootballTeam("Team" + g + "," + i, g, i);
            }
        }
        // 将小组赛加入赛程表
        for (int g = 0; g < nGroups; g++) {
            for (int i = 0; i < nTeams; i++) {
                for (int j = i + 1; j < nTeams; j++) {
                    schedule.addGame(new GroupFootballGame(teams[g][i], teams[g][j]));
                }
            }
        }

        // 进行所有比赛
        ScheduleIterator it = schedule.iterator();
        while (it.hasNext()) {
            it.next().play();
        }


    }

}
