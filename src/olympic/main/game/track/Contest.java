package olympic.main.game.track;

/**
 * 使用了桥接模式,作为桥接模式的抽象化者
 * Contest指的是比赛类
 */
public class Contest {
    /**
     * 桥接模式中的实现者
     */
    private ContestImpl contestImpl;

    /**
     * Contest的构造函数
     * @param contestImpl 桥接模式中的实现者
     */
    public Contest(ContestImpl contestImpl) {
        this.contestImpl = contestImpl;
    }

    /**
     * 开始比赛
     */
    private void start() {
        contestImpl.start();
    }


    /**
     * 取得比赛成果
     */
    private void getResult() {
        contestImpl.getResult();
    }

    /**
     * 外部调用接口，比赛流程展示
     */
    public final void display() {
        System.out.println("classname: (Contest) method: (display) action: (Bridge method模式中运动员参与比赛) ");

        start();
        getResult();
    }
}
