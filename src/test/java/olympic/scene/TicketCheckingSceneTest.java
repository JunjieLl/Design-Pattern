package olympic.scene;

import olympic.main.opening.ticketchecking.CheckingMachine;
import olympic.main.opening.ticketchecking.ElectronicTicket;
import olympic.main.opening.ticketchecking.PaperTicket;
import olympic.main.opening.ticketchecking.TicketChecking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("入场验票场景")
public class TicketCheckingSceneTest {
    /**
     * 入场验票测试函数
     */
    @Test
    void test() {
        CheckingMachine c = new CheckingMachine();
        System.out.println("请输入您的票类：(1:电子票，2:纸质票)");
        testElectronic();
        testPaper();
    }

    void testElectronic() {
        CheckingMachine c = new CheckingMachine();
        TicketChecking s = new ElectronicTicket();
        c.setStrategy(s);
        c.strategyMethod();
    }

    void testPaper() {
        CheckingMachine c = new CheckingMachine();
        TicketChecking s = new PaperTicket();
        c.setStrategy(s);
        c.strategyMethod();
    }
}
