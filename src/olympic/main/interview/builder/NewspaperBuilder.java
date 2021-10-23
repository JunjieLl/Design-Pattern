package olympic.main.interview.builder;

public class NewspaperBuilder extends ReportBuilder {
    public NewspaperBuilder(String interviewerName, String intervieweeName) {
        super(interviewerName, intervieweeName);
    }

    @Override
    public void makeTitle(String extraContent) {
        report = report + "《" + interviewerName + "对" + intervieweeName + "的采访（报纸版）》\n";
    }

    @Override
    public void makeQuestion(String question) {
        report = report + "问题：" + question + '\n';
    }

    @Override
    public void makeAnswer(String answer) {
        report = report + intervieweeName + "：" + answer + '\n';
    }

    @Override
    public void close() {
        report = report + interviewerName + "报道" + '\n' + '\n';
    }
}
