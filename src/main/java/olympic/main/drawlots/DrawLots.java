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
        System.out.println("classname: (DrawLots) method: (drawLotsStart) action: (抽签决定分组或出场顺序，使用了Bridge模式)");
        impl.rawDrawLotsStart(athletes);
    }

    /**
     * 抽签结束
     */
    protected void drawLotsEnd() {
        impl.rawDrawLotsEnd(athletes, groupSize);
    }
}
