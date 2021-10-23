package olympic.main.interview.questionstrategy;

public interface QuestionStrategy {
    void addNote(String content);

    String getQuestion();

    default boolean haveQuestion() {
        return false;
    }
}
