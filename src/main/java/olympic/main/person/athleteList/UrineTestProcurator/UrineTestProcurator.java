package olympic.main.person.athleteList.UrineTestProcurator;

import olympic.main.person.Person;

/**
 * 尿检检察员的抽象类，继承了Person类
 */
public abstract class UrineTestProcurator extends Person {
    /**
     * 尿检检察员的构造函数
     *
     * @param name   检察员姓名
     * @param nation 检察员国家
     */
    protected UrineTestProcurator(String name, String nation) {
        super(name, nation);
    }
    
    /**
     * 抽象函数，作用为检察员检查运动员
     *
     * @param isPrint 控制是否输出classname语句
     */
    public abstract String  check(boolean isPrint);
}

