package olympic.main.person.interview;

import olympic.main.interview.builder.ReportBuilder;
import olympic.main.interview.questionstrategy.PreInterviewStrategy;
import olympic.main.interview.questionstrategy.QuestionStrategy;
import olympic.main.person.Person;

public class Interviewer extends Person implements Listener {

    protected QuestionStrategy questionStrategy = new PreInterviewStrategy();
    protected ReportBuilder reportBuilder;

    public Interviewer(String name, String nation) {
        super(name, nation);
    }

    public Interviewer(String name, String nation, QuestionStrategy questionStrategy) {
        this(name, nation);
        this.questionStrategy = questionStrategy;
    }

    public Interviewer(String name, String nation, QuestionStrategy questionStrategy, ReportBuilder reportBuilder) {
        this(name, nation, questionStrategy);
        this.reportBuilder = reportBuilder;
    }

    public void setStrategy(QuestionStrategy questionStrategy) {
        this.questionStrategy = questionStrategy;
    }

    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    @Override
    public void update(String content) {
        memory.add(content);
        questionStrategy.addNote(content);
    }

    public String ask() {
        return questionStrategy.getQuestion();
    }

    public boolean haveQuestion() {
        return questionStrategy.haveQuestion();
    }

    public ReportBuilder getReportBuilder() {
        return reportBuilder;
    }
}
