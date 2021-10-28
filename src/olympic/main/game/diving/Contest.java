package olympic.main.game.diving;

public interface Contest{
//    void process(AthletePool athletePool);
    void takePlace(AthletePool athletePool);
    void setNext(Contest contest);
    void start();
}
