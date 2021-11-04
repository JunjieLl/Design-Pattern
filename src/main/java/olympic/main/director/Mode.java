package olympic.main.director;


/**
 * 用于控制输出模式
 * 只有静态方法，类似单例
 */
public class Mode {
    private Mode(){};

    private static Boolean showDetail = false;

    private static Boolean needDetail = true;

    public static void setNeedDetail(Boolean needDetail) {
        Mode.needDetail = needDetail;
    }

    public static Boolean getNeedDetail() {
        return needDetail;
    }

    public static void setShowDetail(Boolean showDetail) {
        Mode.showDetail = showDetail;
    }

    public static Boolean getShowDetail() {
        return showDetail;
    }
}
