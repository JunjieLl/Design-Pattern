package olympic.main.game;

import olympic.main.game.football.EliminationRound;
import olympic.main.game.football.FootballGameManager;
import olympic.main.game.football.GroupRound;

public class Test {
    public static void testFootball() {
        FootballGameManager footballGameManager = FootballGameManager.getInstance();
        footballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound("四分之一决赛")).setNext(new EliminationRound("半决赛")).setNext(new EliminationRound("决赛"));
        footballGameManager.start();
    }
}
