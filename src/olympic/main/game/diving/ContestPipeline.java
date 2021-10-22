package olympic.main.game.diving;

public class ContestPipeline implements AbstractPipeline{
    private final Contest firstContest;
    private Contest lastContest;

    ContestPipeline(Contest contest) {
        this.firstContest = contest;
        this.lastContest = contest;
    }

    public void addContest(Contest newContest) {
        lastContest.setNext(newContest);
        lastContest = newContest;
    }

    public void startGame(AthletePool athletePool) {
        firstContest.takePlace(athletePool);
    }
}
