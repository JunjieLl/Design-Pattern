package olympic.main.postgame.awardceremony.prototypeframework;

/**
 * 原型产品的接口
 */
public interface MedalProduct extends Cloneable {
    /**
     * 使用原型展示奖牌
     * @param s 奖牌上展示的信息
     */
    void use(String s);

    /**
     * 克隆一个包含奖牌样式的原型
     * @return 相应原型的克隆
     */
    MedalProduct createClone();
}
