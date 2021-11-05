package olympic.main.opening.performance;

/**
 * 被观察者：主持人
 */
public class Compere extends Observable {
    /**
     * 节目数量
     */
    private int programNum;

    public void setProgramNum(int programNum) {
        this.programNum = programNum;
        this.notifyObserver();
    }

    /**
     * 通知观察者方法
     */
    public void notifyObserver() {
        Observer group ;
        for (Observer observer : observers) {
            group = observer;
            group.update(programNum);
        }
    }
}