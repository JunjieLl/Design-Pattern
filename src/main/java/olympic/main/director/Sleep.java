package olympic.main.director;

/**
 * 用于输出时sleep
 */
public class Sleep {

    /**
     * 私有构造函数，不允许创造实例
     */
    private Sleep() {
    }

    /**
     * 设置是否需要Sleep，测试时可以关掉Sleep
     * @param needSleep 是否需要sleep
     */
    public static void setNeedSleep(Boolean needSleep) {
        Sleep.needSleep = needSleep;
    }

    /**
     * 是否需要测试
     */
    private static Boolean needSleep = true;

    /**
     * sleep
     * @param time 时间长短
     */
    public static void sleep(String time) {
        if (!needSleep){
            return;
        }
        try {
            switch (time){
                case "long":
                    Thread.sleep(1000);
                    break;
                case "short":
                    Thread.sleep(300);
                    break;
                default:
                    break;
            }

            Thread.sleep(1000);
        } catch (
                Exception e) {
            System.exit(0);
        }
    }
}
