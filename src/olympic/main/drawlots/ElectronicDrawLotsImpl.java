package olympic.main.drawlots;

public class ElectronicDrawLotsImpl extends DrawLotsImpl {

    @Override
    public void drawLotsStart() {
        System.out.println("电子抽签开始");
    }

    @Override
    public void drawLotsEnd() {
        System.out.println("电子抽签结束");
    }
}
