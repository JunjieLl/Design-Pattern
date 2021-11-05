package olympic.main.drawlots;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 抽签类的功能层次结构基类
 * 使用的设计模式：
 * 1. Bridge
 */
public class DrawLots {
    /**
     * 需要抽签的运动员列表
     */
    protected List<Athlete> athletes;

    /**
     * 抽签形式，支持的形式：
     * 1. PaperDrawLotsImpl（纸质版）
     * 2. ElectronicDrawLotsImpl（电子版）
     */
    private final DrawLotsImpl impl;

    /**
     * 每个小组的运动员/团队数
     */
    private final int groupSize;

    /**
     * 是否打印详细抽签信息
     */
    protected final boolean showDetail;

    /**
     * 创建抽签类
     *
     * @param athletes   需要抽签的运动员列表
     * @param impl       抽签形式，支持的形式：
     *                   1. PaperDrawLotsImpl（纸质版）
     *                   2. ElectronicDrawLotsImpl（电子版）
     * @param groupSize  每个小组的运动员/团队数
     * @param showDetail 是否打印详细抽签信息
     */
    public DrawLots(List<Athlete> athletes, DrawLotsImpl impl, int groupSize, boolean showDetail) {
        this.athletes = athletes;
        this.impl = impl;
        this.groupSize = groupSize;
        this.showDetail = showDetail;
    }

    /**
     * 抽签开始
     */
    protected void drawLotsStart() {
        impl.rawDrawLotsStart(athletes);
    }

    /**
     * 抽签结束
     */
    protected void drawLotsEnd() {
        impl.rawDrawLotsEnd(athletes, groupSize);
    }


    /**
     * DrawLots（抽签）功能的使用示例
     *
     * @param args 无需指定
     */
    public static void main(String[] args) {
        // 获取待抽签的运动员列表
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        System.out.println(gameNames);
        String gameName = gameNames.get(0);
        List<Athlete> athletes = personFactory.getAthletes(gameName);

        // 随机抽签test
        RandomDrawLots drawLots = new RandomDrawLots(athletes, new PaperDrawLotsImpl(), 2, false);
        List<Athlete> randomSortedAthletes = drawLots.randomDrawLots();

        // 固定次序抽签test
        FixedDrawLots fixedDrawLots = new FixedDrawLots(randomSortedAthletes, new ElectronicDrawLotsImpl(), 1, true);
        List<Integer> orders = List.of(2, 1, 3, 4, 5, 6, 7, 8, 9, 14, 12, 13, 17, 0, 11, 10, 15, 16);
        List<Athlete> fixedSortedAthletes = fixedDrawLots.fixedDrawLots(orders);
    }
}
