package olympic.main.game.diving;

public class ContestPipeline implements AbstractPipeline{
    private final Contest firstContest;
    private Contest lastContest;

    ContestPipeline(Contest contest) {
        this.firstContest = contest;
        this.lastContest = contest;
    }

    @Override
    public void addContest(Contest newContest) {
        lastContest.setNext(newContest);
        lastContest = newContest;
    }

    @Override
    public void startGame(AthletePool athletePool) {
        firstContest.takePlace(athletePool);
    }
}
