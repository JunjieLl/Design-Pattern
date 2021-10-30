package olympic.main.drawlots;

public class PaperDrawLotsImpl extends DrawLotsImpl {
    @Override
    public void drawLotsStart() {
        System.out.println("纸质抽签开始");
    }

    @Override
    public void drawLotsEnd() {
        System.out.println("纸质抽签结束");
    }
}
