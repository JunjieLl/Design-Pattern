package olympic.main.interview.builder;

/**
 * 报告Builder（电子版）
 */
public class InternetReportBuilder extends ReportBuilder {

    /**
     * 创建电子报告Builder
     *
     * @param interviewerName 采访者的名字
     * @param intervieweeName 被采访者的名字
     */
    public InternetReportBuilder(String interviewerName, String intervieweeName) {
        super(interviewerName, intervieweeName);
    }

    /**
     * 创建电子报告标题
     *
     * @param extraContent 在标题中添加的额外信息
     */
    @Override
    public void makeTitle(String extraContent) {
        report = report + interviewerName + "对" + intervieweeName + "的采访（电子版）\n";
    }

    /**
     * 创建电子报告问题
     *
     * @param question 问题内容
     */
    @Override
    public void makeQuestion(String question) {
        report = report + "问题：" + question + '\n';
    }

    /**
     * 创建电子报告回答
     *
     * @param answer 回答内容
     */
    @Override
    public void makeAnswer(String answer) {
        report = report + intervieweeName + "：" + answer + '\n';
    }

    /**
     * 结束电子报告
     */
    @Override
    public void close() {
        report = report + interviewerName + "报道" + '\n';
    }

}
