package olympic.main.interview.builder;

public abstract class ReportBuilder {
    protected String report = "";
    protected String interviewerName;
    protected String intervieweeName;

    public ReportBuilder(String interviewerName, String intervieweeName) {
        this.interviewerName = interviewerName;
        this.intervieweeName = intervieweeName;
    }

    public abstract void makeTitle(String extraContent);

    public abstract void makeQuestion(String question);

    public abstract void makeAnswer(String answer);

    public abstract void close();

    public void showReport() {
        System.out.println(report);
    }
}
