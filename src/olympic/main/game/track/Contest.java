package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

/**
 * 使用了桥接模式,作为桥接模式的抽象化者
 * Contest指的是比赛类
 */
public class Contest {
    private ContestImpl contestImpl;


    public Contest(ContestImpl contestImpl) {
        this.contestImpl = contestImpl;
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
