package olympic.main.director;


/**
 * 用于控制输出模式
 * 只有静态方法，类似单例
 */
public class Mode {
    /**
     * 构造函数
     */
    private Mode(){}

    /**
     * 是否需要输出细节
     * 用户选择
     */
    private static Boolean showDetail = false;

    /**
     * 是否需要输出细节
     * 用于director的输出重定向
     */
    private static Boolean needDetail = true;

    /**
     * 设置needDetail
     * @param needDetail 是否需要细节
     */
    public static void setNeedDetail(Boolean needDetail) {
        Mode.needDetail = needDetail;
    }

    /**
     * 获得是否需要细节
     * @return 是否需要细节
     */
    public static Boolean getNeedDetail() {
        return needDetail;
    }

    /**
     * 设置是否展示细节
     * @param showDetail 是否展示细节
     */
    public static void setShowDetail(Boolean showDetail) {
        Mode.showDetail = showDetail;
    }

    /**
     * 获得是否展示细节
     * @return 是否展示细节
     */
    public static Boolean getShowDetail() {
        return showDetail;
    }
}
