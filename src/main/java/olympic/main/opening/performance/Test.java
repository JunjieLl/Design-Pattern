package olympic.main.opening.performance;

import olympic.Utils.PrintBlockFormat;

public class Test {
    /**
     * 表演的测试函数
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Compere cp = new Compere(); //主持人
        Observer group_1 = new Group(1, "敦煌飞天");
        Observer group_2 = new Group(2, "天女散花");
        Observer group_3 = new Group(3, "武术表演");
        cp.add(group_1); //迭代器
        cp.add(group_2);
        cp.add(group_3);
        PrintBlockFormat.getPrintFormat().addString("节目表演");
        cp.setProgramNum(1);
        PrintBlockFormat.getPrintFormat().addString("-----------------------------------------------------------------------");
        cp.setProgramNum(2);
        PrintBlockFormat.getPrintFormat().addString("-----------------------------------------------------------------------");
        cp.setProgramNum(3);
        PrintBlockFormat.getPrintFormat().addString("-----------------------------------------------------------------------");
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);
    }
}
