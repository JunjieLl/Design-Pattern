package olympic.main.opening.performance;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象被观察者
 * 设计模式：观察者模式
 */
abstract class Observable {
    /**
     * 装观察者的容器
     */
    protected List<Observer> observers = new ArrayList<Observer>();

    /**
     * 设计模式：观察者模式
     * 添加观察者
     *
     * @param observer 观察者
     */
    public void add(Observer observer) {
        observers.add(observer);
    }

    /**
     * 去除观察者
     * @param observer 观察者
     */
//    public void remove(Observer observer) {
//        observers.remove(observer);
//    }

    /**
     * 设计模式：观察者模式
     * 通知观察者
     */
    public abstract void notifyObserver();
}
