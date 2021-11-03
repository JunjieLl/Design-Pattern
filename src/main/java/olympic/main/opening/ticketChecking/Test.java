package olympic.main.opening.ticketChecking;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        CheckingMachine c=new CheckingMachine();
        while(true) {
            System.out.println("请输入您的票类：(1:电子票，2:纸质票)");
            Scanner sc = new Scanner(System.in);
            String type = sc.next();
            if(type.equals("1")) {
                TicketChecking s=new ElectronicTicket();
                c.setStrategy(s);
                c.strategyMethod();
            }
            else if(type.equals("2")) {
                TicketChecking s=new PaperTicket();
                c.setStrategy(s);
                c.strategyMethod();
            }
            else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }
}
