package olympic.main.postgame.award_ceremony.factory;

import java.util.ArrayList;


/**
 * 抽象地表示奖牌产品的类.
 */
public abstract class EndProduct {
    protected String productName;
    protected ArrayList content = new ArrayList();

    public EndProduct(String productName) {
        this.productName = productName;
    }


    /**
     * @param part 需要添加给产品的零件
     */
    public void add(Part part) {
        content.add(part);
    }

    /**
     * 展示产品制作过程的入口.
     */
    public void present() {
        this.makeMedal();
    }

    /**
     * 零件调用展示具体过程.
     */
    public abstract void makeMedal();
}
