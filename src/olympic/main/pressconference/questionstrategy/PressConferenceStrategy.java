package olympic.main.pressconference.questionstrategy;

import olympic.main.interview.questionstrategy.QuestionStrategy;

import java.util.ArrayList;

public class PressConferenceStrategy implements QuestionStrategy {
    private final ArrayList<String> notes = new ArrayList<>();

    @Override
    public void addNote(String content) {
        notes.add(content);
    }

    @Override
    public String getQuestion() {
        return null;
    }
}
