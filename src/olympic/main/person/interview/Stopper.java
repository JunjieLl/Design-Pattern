package olympic.main.person.interview;

import olympic.main.person.Person;

/**
 * 控制采访与新闻发布会的停止
 */
public class Stopper extends Person implements Listener {
    /**
     * 最大提问数量
     */
    private final int maxQuestionNum;

    /**
     * 当前提问数量
     */
    private int currentQuestionNum = 0;

    /**
     * 创建一个Stopper
     *
     * @param name           名字
     * @param nation         国家哎
     * @param maxQuestionNum 最大问题数
     */
    public Stopper(String name, String nation, int maxQuestionNum) {
        super(name, nation);
        this.maxQuestionNum = maxQuestionNum;
    }

    /**
     * 通知Observer更新
     *
     * @param content 通知内容
     */
    @Override
    public void update(String content) {
        memory.add(content);
        currentQuestionNum++;
        if (content.equals(Interviewee.STOP_WORD)) {
            currentQuestionNum = maxQuestionNum;
        }
    }

    /**
     * 判断是否应该继续采访/新闻发布会
     *
     * @return 是否应该继续
     */
    public boolean shouldContinue() {
        return currentQuestionNum < maxQuestionNum;
    }
}
