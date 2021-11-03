package olympic.scene;

import olympic.main.postgame.chores.*;
import olympic.scene.Scene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * 赛后杂务处理的场景.
 */
public class ChoreHandlingScene implements Scene {

    @Override
    public void play() {
        System.out.println("\nclassname: (ChoreHandlingScene) method: (play) action: (展示赛后杂务处理场景) ");
        System.out.println("正在整理杂事...");
        System.out.println("以下为当前杂事清单");
        ChoreComposite allTheChore;

        //用ChoreGenerating类来生成杂事清单.
        allTheChore = new ChoreGenerating().getGaneratedComposite();

        allTheChore.printList("杂事清单");

        System.out.println("\nclassname: (ChoreHandlingScene) method: (play) action: (开始展示杂务处理过程) ");
        System.out.println("正在利用责任链处理杂事...");
        Support security = new SecuritySupport("安保小组", 1);
        Support cleaning = new SecuritySupport("保洁小组", 2);
        Support audience = new SecuritySupport("观众辅助小组", 3);
        Support other = new SecuritySupport("机动小组", 4);

        //设置责任链.
        audience.setNext(cleaning).setNext(security).setNext(other);

        //添加访问者
        allTheChore.accept(new LeafVisitor(audience));

        System.out.println("\nclassname: (ChoreHandlingScene) method: (play) action: (展示处理后的杂务清单) ");
        System.out.println("处理完成，以下为当前杂事清单...");
        allTheChore.printList("杂事清单");
    }


}
