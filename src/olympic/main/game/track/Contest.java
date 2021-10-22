package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

/**
 * 使用了桥接模式
 */
public class Contest {
    private ContestImpl contestImpl;
    private Athlete[] athletes;

    public Contest(ContestImpl contestImpl, Athlete[] athlete) {
        this.contestImpl = contestImpl;
        this.athletes = athletes;
    }

    public void start() {
        contestImpl.start();
    }

    public void getParticipants() {
        contestImpl.getParticipants();
    }

    public void getResult() {
        contestImpl.getResult();
    }

    public final void display() {
        getParticipants();
        start();
        getResult();
    }
}
