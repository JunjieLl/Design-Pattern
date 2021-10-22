package olympic.main.game.diving;

import java.util.Random;

public interface Contest{
    void process(AthletePool athletePool , Random random);
    void takePlace(AthletePool athletePool);
    void setNext(Contest contest);
}
