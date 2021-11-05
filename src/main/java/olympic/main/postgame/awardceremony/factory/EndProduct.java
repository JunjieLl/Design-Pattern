package olympic.main.postgame.awardceremony.factory;

import java.util.ArrayList;
import java.util.List;


/**
 * 抽象地表示奖牌产品的类.
 */
public abstract class EndProduct {

    /**
     * 产品名
     */
    protected String productName;

    /**
     * 产品的零件列表
     */
    protected final List<Part> content = new ArrayList<>();

    /**
     * 产品构造函数
     *
     * @param productName 产品名
     */
    public EndProduct(String productName) {
        this.productName = productName;
    }

    /**
     * 产品组装零件
     *
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
