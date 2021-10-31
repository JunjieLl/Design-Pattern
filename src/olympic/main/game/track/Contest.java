package olympic.main.game.track;

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



    public void getResult() {
        contestImpl.getResult();
    }

    public final void display() {
        System.out.println("classname: (Contest) method: (display) action: (Bridge method模式中运动员参与比赛) ");

        start();
        getResult();
    }
}
