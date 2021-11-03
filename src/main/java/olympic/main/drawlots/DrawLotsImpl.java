package olympic.main.drawlots;

import olympic.main.person.athlete.*;

import java.util.List;

/**
 * 抽签类的实现层次结构基类
 * 使用的设计模式：
 * 1. Bridge
 */
public abstract class DrawLotsImpl {
    /**
     * 分隔符长度{@value}
     */
    protected static final int SEPARATOR_LENGTH = 70;

    /**
     * 开头与结尾缩进长度{@value}
     */
    protected static final int START_END_SEPARATOR_LENGTH = DrawLotsImpl.SEPARATOR_LENGTH / 2 - 7;

    /**
     * 抽签前缩进长度{@value}
     */
    protected static final int BEFORE_SEPARATOR_LENGTH = DrawLotsImpl.SEPARATOR_LENGTH / 2 - 10;

    /**
     * 抽签结果缩进长度{@value}
     */
    protected static final int RESULT_SEPARATOR_LENGTH = DrawLotsImpl.SEPARATOR_LENGTH / 2 - 5;

    /**
     * 抽签开始前输出抽签实现形式，以及参与抽签的运动员或团队
     *
     * @param athletes 运动员列表
     */
    public abstract void rawDrawLotsStart(List<Athlete> athletes);

    /**
     * 抽签结束后输出抽签结果，并输出抽签实现形式
     *
     * @param athletes  运动员列表
     * @param groupSize 每个小组中的运动员数
     */
    public abstract void rawDrawLotsEnd(List<Athlete> athletes, int groupSize);

    /**
     * 输出参与抽签的运动员或团队
     *
     * @param athletes 运动员列表
     */
    protected void showBeforeAthletes(List<Athlete> athletes) {
        int index = 1;
        for (Athlete athlete : athletes) {
            System.out.println(index + ".\t" + athlete.getName());
            index++;
        }
    }

    /**
     * 抽签结束后输出抽签结果
     *
     * @param athletes  运动员列表
     * @param groupSize 每个小组中的运动员数
     */
    protected void showAfterAthletes(List<Athlete> athletes, int groupSize) {
        int index = 1;
        for (int i = 0; i < athletes.size(); ) {
            System.out.print(index + ".\t");
            for (int j = 0; j < groupSize; j++, i++) {
                System.out.printf("%-19s\t", athletes.get(i).getName());
            }
            System.out.println();
            index++;
        }
    }

    /**
     * 工具函数，输出指定数量的空格
     *
     * @param spaceNum 输出的空格数
     */
    protected void printSpaces(int spaceNum) {
        for (int i = 0; i < spaceNum; i++) {
            System.out.print(' ');
        }
    }
}
