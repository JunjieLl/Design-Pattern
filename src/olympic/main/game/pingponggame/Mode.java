package olympic.main.game.pingponggame;


/**
 * 用于控制输出模式
 * 只有静态方法，类似单例
 */
public class Mode {
    private Mode(){};

    private static Boolean showDetail = true;

    public static void setShowDetail(Boolean showDetail) {
        Mode.showDetail = showDetail;
    }

    public static Boolean getShowDetail() {
        return showDetail;
    }
}
