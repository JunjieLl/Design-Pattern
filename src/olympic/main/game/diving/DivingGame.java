package olympic.main.game.diving;

import olympic.main.game.Game;
import olympic.main.game.Valve;

public abstract class DivingGame extends Valve {
    abstract void takePlace(AthletePool athletePool);
}
