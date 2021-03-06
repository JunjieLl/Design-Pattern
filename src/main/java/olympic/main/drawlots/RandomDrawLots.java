package olympic.main.drawlots;

import olympic.main.person.athlete.Athlete;

import java.util.*;

/**
 * 随机分组的抽签功能
 */
public class RandomDrawLots extends DrawLots {
    /**
     * 创建随机分组抽签类
     *
     * @param athletes   需要抽签的运动员列表
     * @param impl       抽签形式
     * @param groupSize  每个小组的运动员/团队数
     * @param showDetail 是否打印详细抽签信息
     */
    public RandomDrawLots(List<Athlete> athletes, DrawLotsImpl impl, int groupSize, boolean showDetail) {
        super(athletes, impl, groupSize, showDetail);
    }

    /**
     * 随机分组的抽签
     *
     * @return 排好序的运动员列表
     */
    public List<Athlete> randomDrawLots() {
        if (showDetail) {
            drawLotsStart();
        }
        Collections.shuffle(athletes);
        if (showDetail) {
            drawLotsEnd();
        }
        return athletes;
    }
}
