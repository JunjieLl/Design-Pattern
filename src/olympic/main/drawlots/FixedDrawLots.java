package olympic.main.drawlots;

import olympic.main.person.athlete.Athlete;

import java.util.*;

/**
 * 指定次序的抽签功能
 */
public class FixedDrawLots extends DrawLots {
    /**
     * 创建指定次序抽签类
     *
     * @param athletes   需要抽签的运动员列表
     * @param impl       抽签形式
     * @param groupSize  每个小组的运动员/团队数
     * @param showDetail 是否打印详细抽签信息
     */
    public FixedDrawLots(List<Athlete> athletes, DrawLotsImpl impl, int groupSize, boolean showDetail) {
        super(athletes, impl, groupSize, showDetail);
    }

    /**
     * 指定次序的抽签
     *
     * @param orders 抽签次序
     * @return 排好序的运动员列表
     */
    public List<Athlete> fixedDrawLots(List<Integer> orders) {
        if (showDetail) {
            drawLotsStart();
        }
        if (orders.size() != athletes.size()) {
            return null;
        }
        long count = orders.stream().distinct().count();
        if (orders.size() != count) {
            return null;
        }
        List<Athlete> sortedAthleteList = new ArrayList<>();
        for (int order : orders) {
            if (order >= athletes.size()) {
                return null;
            }
            sortedAthleteList.add(athletes.get(order));
        }
        athletes = sortedAthleteList;
        if (showDetail) {
            drawLotsEnd();
        }
        return athletes;
    }
}
