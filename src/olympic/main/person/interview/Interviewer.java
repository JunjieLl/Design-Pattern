package olympic.main.person.interview;

import olympic.main.interview.builder.ReportBuilder;
import olympic.main.interview.questionstrategy.InterviewStrategy;
import olympic.main.interview.questionstrategy.PreInterviewStrategy;
import olympic.main.interview.questionstrategy.QuestionStrategy;
import olympic.main.person.Person;

import java.util.ArrayList;

public class Interviewer extends Person implements Listener {

    protected QuestionStrategy questionStrategy = new PreInterviewStrategy();
    protected ReportBuilder reportBuilder;

    public Interviewer(String name, String gender) {
        super(name, gender);
    }

    public Interviewer(String name, String gender, QuestionStrategy questionStrategy, ReportBuilder reportBuilder) {
        super(name, gender);
        this.questionStrategy = questionStrategy;
        this.reportBuilder = reportBuilder;
    }

    public void setStrategy(QuestionStrategy questionStrategy) {
        this.questionStrategy = questionStrategy;
    }
    public void setReportBuilder(ReportBuilder reportBuilder) {this.reportBuilder = reportBuilder;}

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

    public String getName() {
        return this.name;
    }

    public ReportBuilder getReportBuilder() {
        return reportBuilder;
    }
}
