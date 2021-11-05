package olympic.main.opening.ticketChecking;

import java.util.Scanner;

public class Test {
    /**
     * 验票的测试函数
     * @param args main参数
     */
    public static void main(String[] args) {
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
