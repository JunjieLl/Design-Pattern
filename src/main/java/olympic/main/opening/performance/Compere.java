package olympic.main.opening.performance;

/**
 * 被观察者：主持人
 */
public class Compere extends Observable {
    private int programNum;

    public void setProgramNum(int programNum) {
        this.programNum = programNum;
        this.notifyObserver();
    }

    public void notifyObserver() {
        Observer group ;
        for (Observer observer : observers) {
            group = observer;
            group.update(programNum);
        }
    }
}