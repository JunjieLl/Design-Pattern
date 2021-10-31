package olympic.main.interview.questionstrategy;

public interface QuestionStrategy {
    void addNote(String content);

    String getQuestion();

    boolean haveQuestion();
}
