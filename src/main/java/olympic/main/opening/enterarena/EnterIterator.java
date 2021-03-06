package olympic.main.opening.enterarena;

import olympic.main.game.Iterator;
import olympic.main.person.athlete.TeamAthlete;

/**
 * 入场迭代器 顺序访问所有队伍
 */
public class EnterIterator implements Iterator {
    private EnterManager list;
    private int index;

    /**
     * 入场迭代器构造函数
     * @param list 添加所有国家队
     */
    public EnterIterator(EnterManager list) {
        this.list = list;
        this.index = 0;
    }

    /**
     * 设计模式：迭代器模式
     * @return boolean 判断是否有下一个队员
     */
    @Override
    public boolean hasNext() {
        return this.index < list.getLength();
    }

    /**
     *设计模式：迭代器模式
     * @return TeamAthlete 返回下一个队员
     */
    @Override
    public TeamAthlete next() {
        TeamAthlete allList = list.getTeamAt(this.index);
        this.index++;
        return allList;
    }

}
