package olympic.main.person.interview;

import olympic.main.person.Person;

import java.util.*;
import java.util.Random;

public abstract class Interviewee extends Person implements Listener {
    public final static String STOP_WORD = "不想回答这个问题";
    private final ArrayList<Listener> listeners = new ArrayList<>();

    protected Interviewee(String name, String nation) {
        super(name, nation);
    }

    public ArrayList<Listener> getListeners() {
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
        } else {
            return content;
        }
    }

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
