package olympic.main.game.diving;

import olympic.main.game.Game;

public abstract class DivingGame extends Game {
    abstract void takePlace(AthletePool athletePool);
    abstract void setNext(DivingGame divingGame);
}
