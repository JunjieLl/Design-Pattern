package olympic.scene;

import olympic.main.postgame.chores.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试杂物处理场景
 */
@DisplayName("杂务处理场景")
class ChoreHandlingSceneTest {
    /**
     * 测试ChoreHandlingScene.play()方法
     */
    @Test
    void testPlay(){
        ChoreHandlingScene choreHandlingScene = new ChoreHandlingScene();
        choreHandlingScene.play();
    }

    /**
     * 模拟流程测试责任链
     */
    @Test
    void testChainResponsibility(){
        ChoreComposite allTheChore;
        //用ChoreGenerating类来生成杂务清单.
        allTheChore = new ChoreGenerating().getGeneratedComposite();
        Support security = new SecuritySupport("安保小组");
        Support cleaning = new CleaningSupport("保洁小组");
        Support audience = new AudienceSupport("观众辅助小组");
        Support other = new OtherSupport("机动小组");
        audience.setNext(cleaning).setNext(security).setNext(other);
        allTheChore.accept(new LeafVisitor(audience));

        System.out.println("Succeeded");
    }

    /**
     * 测试组合模式的杂务树
     */
    @Test
    void testPrintList(){
        ChoreComposite allTheChore;
        allTheChore = new ChoreGenerating().getGeneratedComposite();
        allTheChore.printList("杂务清单");
        System.out.println("Succeeded");
    }
}
