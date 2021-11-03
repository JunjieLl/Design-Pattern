package olympic.main.person.interview;

import olympic.main.interview.builder.*;
import olympic.main.interview.questionstrategy.PreInterviewAthleteStrategy;
import olympic.main.interview.questionstrategy.QuestionStrategy;
import olympic.main.person.Person;

/**
 * 采访者（观察者）
 * 使用的设计模式：
 * 1. 观察者模式
 */
public class Interviewer extends Person implements Listener {

    /**
     * 提问Strategy
     */
    protected QuestionStrategy questionStrategy;

    /**
     * 攥写采访报告的Builder
     */
    protected ReportBuilder reportBuilder;

    /**
     * 创建采访者
     *
     * @param name   名字
     * @param nation 国家
     */
    public Interviewer(String name, String nation) {
        this(name, nation, new PreInterviewAthleteStrategy());
    }

    /**
     * 创建采访者
     *
     * @param name             名字
     * @param nation           国家
     * @param questionStrategy 提问Strategy
     */
    public Interviewer(String name, String nation, QuestionStrategy questionStrategy) {
        this(name, nation, questionStrategy, new NewspaperBuilder("None", "None"));
    }

    /**
     * 创建采访者
     *
     * @param name             名字
     * @param nation           国家
     * @param questionStrategy 提问Strategy
     * @param reportBuilder    报告Builder
     */
    public Interviewer(String name, String nation, QuestionStrategy questionStrategy, ReportBuilder reportBuilder) {
        super(name, nation);
        this.questionStrategy = questionStrategy;
        this.reportBuilder = reportBuilder;
    }

    /**
     * 设定采访Strategy
     *
     * @param questionStrategy 设定的采访Strategy
     */
    public void setStrategy(QuestionStrategy questionStrategy) {
        this.questionStrategy = questionStrategy;
    }

    /**
     * 设定报告Builder
     *
     * @param reportBuilder 设定的报告Builder
     */
    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    /**
     * 被观察者通知观察者
     *
     * @param content 通知内容（answer）
     */
    @Override
    public void update(String content) {
        memory.add(content);
        questionStrategy.addNote(content);
    }

    /**
     * 采访者提问
     *
     * @return 采访者提问的问题
     */
    public String ask() {
        return questionStrategy.getQuestion();
    }

    /**
     * 判断采访者是否还有问题
     *
     * @return 采访者是否还有问题
     */
    public boolean haveQuestion() {
        return questionStrategy.haveQuestion();
    }

    /**
     * 获得报告Builder
     *
     * @return 报告Builder
     */
    public ReportBuilder getReportBuilder() {
        return reportBuilder;
    }
}
