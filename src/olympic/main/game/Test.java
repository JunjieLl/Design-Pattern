package olympic.main.game;

import olympic.main.game.football.EliminationRound;
import olympic.main.game.football.FootballGameManager;
import olympic.main.game.football.GroupRound;

public class Test {
    public static void testFootball() {
        FootballGameManager footballGameManager = FootballGameManager.getInstance();
        footballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound()).setNext(new EliminationRound()).setNext(new EliminationRound());
        footballGameManager.start();
    }
}
