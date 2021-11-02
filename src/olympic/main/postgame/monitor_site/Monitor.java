package olympic.main.postgame.monitor_site;
/**
 * 设计模式：命令模式
 * 命令接收者：监视器
 */
public class Monitor{

    public void playSite1() {
        System.out.println("classname: (Monitor) method: (playSite1) action: (正在监视1号场地:主会场)");
    }

    public void playSite2() {
        System.out.println("classname: (Monitor) method: (playSite1) action: (正在监视2号场地:游泳馆)");

    }

    public void playSite3() {
        System.out.println("classname: (Monitor) method: (playSite1) action: (正在监视3号场地:足球场)");
    }

    public void playSite4() {

        System.out.println("classname: (Monitor) method: (playSite1) action: (正在监视4号场地:乒乓球场)");
    }

    public void playSite5() {
        System.out.println("classname: (Monitor) method: (playSite1) action: (正在监视5号场地:田径场)");
    }


}
