package olympic.main.opening.performance;

import java.util.Iterator;

/**
 * 被观察者：主持人
 */
public class Compere extends Observable {
    /**
     * 节目数量
     */
    private int programNum;

    /**
     * 获取节目数量
     * @return
     */
    public int getProgramNum() {
        return this.programNum;
    }

    /**
     * 设置节目数量
     * @param programNum
     */
    public void setProgramNum(int programNum) {
        this.programNum = programNum;
        this.notifyObserver();
    }

    /**
     * 通知观察者方法
     */
    public void notifyObserver() {
        Observer group = null;
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            group = iterator.next();
            group.update(programNum);
        }
    }
}