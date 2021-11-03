package olympic.main.postgame.chores;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 表示组合杂务的类.
 */
public class ChoreComposite extends ChoreComponent{
    private String name;
    private ArrayList problemDirectory = new ArrayList();
    public ChoreComposite(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * @return 返回该组合杂务还剩下多少问题待解决.
     */
    @Override
    public int getRemainTrouble() {
        int remain = 0;
        Iterator it = problemDirectory.iterator();
        while(it.hasNext()){
            ChoreComponent component = (ChoreComponent) it.next();
            remain += component.getRemainTrouble();
        }
        return remain;
    }

    /**
     * @param component 添加到组合杂务的对象，可以是新的组合杂务，也可以直接是杂务.
     */
    public void add(ChoreComponent component){
        problemDirectory.add(component);
    }

    public ArrayList getProblemDirectory(){
        return this.problemDirectory;
    }

    /**
     * 打印当前杂务清单
     * @param prefix 当前项的父项.
     */
    @Override
    public void printList(String prefix) {
        System.out.println("\nclassname: (ChoreComposite) method: (printList) action: (显示杂务项) ");
        System.out.println(prefix + "/" + this);
        Iterator it = problemDirectory.iterator();
        while(it.hasNext()){
            ChoreComponent cc = (ChoreComponent) it.next();
            cc.printList(prefix+"/"+name);
        }
    }

    /**
     * @param v 访问杂务清单的访问者
     */
    public void accept(ChoreVisitor v){
        v.visit(this);
    }

    /**
     * @return 返回当前组合杂务Arraylist的迭代器.
     */
    public Iterator iterator() {      // 生成Iterator
        return problemDirectory.iterator();
    }
}
