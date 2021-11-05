package olympic.main.postgame.awardceremony.prototypeframework;

import java.util.*;

/**
 * 管理原型的类
 */
public class Manager {
    /**
     * 原型与名称的映射
     */
    private Map<String, MedalProduct> showcase = new HashMap<>();

    /**
     * 注册原型
     * @param name 原型的简称
     * @param proto 注册的对象原型
     */
    public void register(String name, MedalProduct proto){
        showcase.put(name,proto);
    }

    /**
     * 创建原型的克隆
     * @param protoName 原型简称
     * @return 克隆的原型
     */
    public MedalProduct create(String protoName){
        MedalProduct p = showcase.get(protoName);
        return p.createClone();
    }
}
