package olympic.main.postgame.monitorsite;

/**
 * 设计模式：命令模式
 * 命令接收者：监视器
 */
public class Monitor {

    /**
     * 实现对1号场地——主会场的监视
     */
    public void playSite1() {
        System.out.println("classname: (Monitor) method: (playSite1) action: (正在监视1号场地:主会场)");
    }
    /**
     * 实现对2号场地——游泳馆的监视
     */
    public void playSite2() {
        System.out.println("classname: (Monitor) method: (playSite1) action: (正在监视2号场地:游泳馆)");

    }
    /**
     * 实现对3号场地——足球场的监视
     */
    public void playSite3() {
        System.out.println("classname: (Monitor) method: (playSite1) action: (正在监视3号场地:足球场)");
    }
    /**
     * 实现对4号场地——乒乓球场的监视
     */
    public void playSite4() {

        System.out.println("classname: (Monitor) method: (playSite1) action: (正在监视4号场地:乒乓球场)");
    }
    /**
     * 实现对5号场地——田径场的监视
     */
    public void playSite5() {
        System.out.println("classname: (Monitor) method: (playSite1) action: (正在监视5号场地:田径场)");
    }


}
