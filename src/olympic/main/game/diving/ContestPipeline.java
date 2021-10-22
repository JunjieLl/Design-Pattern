package olympic.main.game.diving;

public class ContestPipeline {
    private final Contest firstContest;
    private Contest lastContest;

    ContestPipeline(Contest contest) {
        this.firstContest = contest;
        this.lastContest = contest;
    }

    void addContest(Contest newContest) {
        lastContest.setNext(newContest);
        lastContest = newContest;
    }

    void startGame(AthletePool athletePool) {
        firstContest.takePlace(athletePool);
    }
}
