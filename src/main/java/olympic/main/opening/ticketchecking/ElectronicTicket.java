package olympic.main.opening.ticketchecking;


/**
 * 电子票
 */
public class ElectronicTicket implements TicketChecking {

    /**
     * 电子检票机的验票方法
     */
    public void checkMethod() {
        System.out.println("classname:(ElectronicTicket) method:(checkMethod) action:(使用电子检票口)");
    }
}