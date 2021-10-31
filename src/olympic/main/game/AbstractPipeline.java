package olympic.main.game;

import olympic.main.game.Game;
import olympic.main.game.Valve;

public interface AbstractPipeline {
    void addContest(Valve newGame);
    void start();
}
