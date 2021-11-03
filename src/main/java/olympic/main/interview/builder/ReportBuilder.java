package olympic.main.interview.builder;

/**
 * 报告Builder抽象基类
 * 使用的设计模式：
 * 1. Builder
 */
public abstract class ReportBuilder {
    /**
     * 编写出的报告
     */
    protected String report = "";

    /**
     * 采访者的名字
     */
    protected String interviewerName;

    /**
     * 被采访者的名字
     */
    protected String intervieweeName;

    /**
     * 创建报告Builder
     *
     * @param interviewerName 采访者的名字
     * @param intervieweeName 被采访者的名字
     */
    public ReportBuilder(String interviewerName, String intervieweeName) {
        this.interviewerName = interviewerName;
        this.intervieweeName = intervieweeName;
    }

    /**
     * 创建报告标题
     *
     * @param extraContent 在标题中添加的额外信息
     */
    public abstract void makeTitle(String extraContent);

    /**
     * 创建报告问题
     *
     * @param question 问题内容
     */
    public abstract void makeQuestion(String question);

    /**
     * 创建报告回答
     *
     * @param answer 回答内容
     */
    public abstract void makeAnswer(String answer);

    /**
     * 结束报告
     */
    public abstract void close();

    /**
     * 展示报告
     */
    public void showReport() {
        System.out.println(report);
    }
}
