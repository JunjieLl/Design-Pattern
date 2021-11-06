package olympic.scene;

import olympic.utils.PrintBlockFormat;
import olympic.main.opening.performance.Compere;
import olympic.main.opening.performance.Group;
import olympic.main.opening.performance.Observer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("表演场景")
public class PerformanceSceneTest {
    /**
     * 表演测试函数
     */
    @Test
    void testPlay()
    {
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
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);
    }
}
