package olympic.scene;

import olympic.main.opening.performance.Compere;
import olympic.main.opening.performance.Group;
import olympic.main.opening.performance.Observer;

/**
 * 设计模式：观察者模式、迭代器模式
 * 节目表演
 */
public class PerformanceScene implements Scene{
    @Override
    public void play() {
        Compere cp = new Compere(); //主持人
        Observer group_1  = new Group(1,"敦煌飞天");
        Observer group_2  = new Group (2,"天女散花");
        Observer group_3  = new Group (3,"武术表演");
        cp.add(group_1); //迭代器
        cp.add(group_2);
        cp.add(group_3);
        cp.setProgramNum(1);
        System.out.println("-----------------------------");
        cp.setProgramNum(2);
        System.out.println("-----------------------------");
        cp.setProgramNum(3);
        System.out.println("-----------------------------");
    }
}