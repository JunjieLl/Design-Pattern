package olympic.main.opening.ticketchecking;

/**
 * 纸质票
 */
public class PaperTicket implements TicketChecking {
    /**
     * 纸质票的验票方法
     */
    public void checkMethod() {
        System.out.println("classname:(PaperTicket) method:(checkMethod) action:(使用纸质检票口)");
    }
}