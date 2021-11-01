package olympic.scene.Performance;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Compere cp = new Compere(); //主持人
        Observer group_1  = new Group (1,"敦煌飞天");
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
