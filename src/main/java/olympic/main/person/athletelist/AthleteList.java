package olympic.main.person.athletelist;

import olympic.main.person.personvisitor.Visitor;

/**
 * 运动员列表的抽象接口
 */
public interface AthleteList {
    /**
     * 用于接收一个Visitor访问类
     *
     * @param v 一个访问器，用于访问该类，对该类做操作
     */
    void accept(Visitor v);

}
