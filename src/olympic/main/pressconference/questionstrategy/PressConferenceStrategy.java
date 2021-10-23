package olympic.main.pressconference.questionstrategy;

import olympic.main.interview.questionstrategy.QuestionStrategy;

import java.util.ArrayList;
import java.util.Random;

public class PressConferenceStrategy implements QuestionStrategy {
    private final ArrayList<String> notes = new ArrayList<>();

    @Override
    public void addNote(String content) {
        notes.add(content);
    }

    @Override
    public String getQuestion() {
        Random random = new Random();
        int randomIndex = random.nextInt(notes.size());
        String question = notes.get(randomIndex);
        notes.remove(randomIndex);
        return question;
    }

    @Override
    public boolean haveQuestion() {
        return !notes.isEmpty();
    }


}
