package olympic.main.interview.questionstrategy;

/**
 * 提问Strategy抽象接口
 * 使用的设计模式：
 * 1. Strategy
 */
public interface QuestionStrategy {
    /**
     * 添加新闻发布会笔记
     *
     * @param content 笔记内容
     */
    void addNote(String content);

    /**
     * 获取要问的问题
     *
     * @return 要问的问题
     */
    String getQuestion();

    /**
     * 判读是否还有没问的问题
     *
     * @return 是否还有没问的问题
     */
    boolean haveQuestion();
}
