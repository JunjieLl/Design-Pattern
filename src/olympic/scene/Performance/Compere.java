package olympic.scene.Performance;

import java.util.Iterator;

/**
 * 被观察者：主持人
 */
class Compere extends Observable
{
    private int programNum;
    public int getProgramNum(){
        return this.programNum;
    }
    public void setProgramNum(int programNum){
        this.programNum=programNum;
        this.notifyObserver();
    }
    public void notifyObserver(){
        Observer group = null;
        Iterator<Observer> iterator = observers.iterator();
        while(iterator.hasNext()){
            group = iterator.next();
            group.update(programNum);
        }
    }
}