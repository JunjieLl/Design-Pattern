package olympic.main.game.diving;

public interface AbstractPipeline {
    void addContest(Contest newContest);
    void startGame(AthletePool athletePool);
}
