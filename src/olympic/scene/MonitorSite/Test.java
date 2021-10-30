package olympic.scene.MonitorSite;

public class Test {
    public static void main(String[] args) {
        Monitor tv = new Monitor();
        //创建一个遥控器
        MonitorController teleController = new MonitorController();

        teleController.switchCommand(new CCTV1Command(tv));
        teleController.switchCommand(new CCTV2Command(tv));
        teleController.switchCommand(new CCTV4Command(tv));
        teleController.switchCommand(new CCTV3Command(tv));
        teleController.switchCommand(new CCTV5Command(tv));
        teleController.switchCommand(new CCTV1Command(tv));
        teleController.switchCommand(new CCTV6Command(tv));
        System.out.println("------返回上一个卫视--------");
        //模拟遥控器返回键
        teleController.back();
        teleController.back();
    }
    //创建一个电视机


}
