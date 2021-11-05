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
     * @param list
     */
    public EnterIterator(EnterManager list) {
        this.list = list;
        this.index = 0;
    }

    /**
     * 设计模式：迭代器模式
     * 判断是否有下一个队员
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        if (this.index < list.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *设计模式：迭代器模式
     *返回下一个队员
     * @return TeamAthlete
     */

    @Override
    public TeamAthlete next() {
        TeamAthlete allList = list.getTeamAt(this.index);
        this.index++;
        return allList;
    }

}
