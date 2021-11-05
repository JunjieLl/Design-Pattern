package olympic.scene;

import olympic.main.opening.ticketChecking.CheckingMachine;
import olympic.main.opening.ticketChecking.ElectronicTicket;
import olympic.main.opening.ticketChecking.PaperTicket;
import olympic.main.opening.ticketChecking.TicketChecking;

import java.util.Scanner;

/**
 * 设计模式：策略模式
 * 入场检票
 */
public class TicketCheckingScene implements Scene {
    @Override
    public void play() {
        CheckingMachine c = new CheckingMachine();
        while (true) {
            System.out.println("请输入您的票类：(1:电子票，2:纸质票)");
            Scanner sc = new Scanner(System.in);
            String type = sc.next();
            if (type.equals("1")) {
                TicketChecking s = new ElectronicTicket();
                c.setStrategy(s);
                c.strategyMethod();
                break;
            } else if (type.equals("2")) {
                TicketChecking s = new PaperTicket();
                c.setStrategy(s);
                c.strategyMethod();
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }
}
