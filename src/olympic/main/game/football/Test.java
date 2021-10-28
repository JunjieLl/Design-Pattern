package olympic.main.game.football;

import olympic.main.game.Game;

public class Test extends Game {

    @Override
    public void start() {
        FootballGameManager footballGameManager = FootballGameManager.getInstance();
        footballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound("四分之一决赛")).setNext(new EliminationRound("半决赛")).setNext(new EliminationRound("决赛"));
        footballGameManager.start();
    }
}
