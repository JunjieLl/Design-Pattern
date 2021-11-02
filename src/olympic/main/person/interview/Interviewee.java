package olympic.main.person.interview;

import olympic.main.person.Person;

import java.util.*;
import java.util.Random;
import java.util.regex.Pattern;

public abstract class Interviewee extends Person implements Listener {
    public static final String STOP_WORD = "不想回答这个问题";
    private static final String pressConferencePattern = ".*发起提问.*";

    private final List<Listener> listeners = new ArrayList<>();

    protected Interviewee(String name, String nation) {
        super(name, nation);
    }

    public List<Listener> getListeners() {
        return listeners;
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void deleteListener(Listener listener) {
        listeners.remove(listener);
    }

    public String answerQuestion(String content) {
        Random random = new Random();
        int stopNum = random.nextInt(10);
        if (stopNum == 0) {
            return STOP_WORD;
        } else if (Pattern.matches(pressConferencePattern, content)) {
            return "\"对问题的回答\"";
        } else {
            return pickOneAnswer(content);
        }
    }

    public String pickOneAnswer(String content) {
        List<String> answers = getAnswers(content);
        Random random = new Random();
        int randomIndex = random.nextInt(answers.size());
        return answers.get(randomIndex);
    }

    public abstract List<String> getAnswers(String content);

    public void notifyListeners(String content) {
        for (Listener o : listeners) {
            o.update(content);
        }
    }

    public List<String> makeSpeech() {
        Random random = new Random();
        int talkNum = random.nextInt(10) + 1;
        List<String> speech = new ArrayList<>();
        for (int i = 0; i < talkNum; i++) {
            speech.add("讲话" + i);
        }
        return speech;
    }
}
