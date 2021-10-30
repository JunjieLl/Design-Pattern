package olympic.main.person.interview;

import olympic.main.person.Person;

import java.util.ArrayList;
import java.util.Random;

public abstract class Interviewee extends Person implements Listener {
    private final ArrayList<Listener> listeners = new ArrayList<>();

    protected Interviewee(String name, String gender) {
        super(name,nation);
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
        return this.name + "回答问题：" + content;
    }

    public void notifyListeners(String content) {
        for (Listener o : listeners) {
            o.update(content);
        }
    }

    public ArrayList<String> makeSpeech() {
        Random random = new Random();
        int talkNum = random.nextInt(10) + 1;
        ArrayList<String> speech = new ArrayList<>();
        for (int i = 0; i < talkNum; i++) {
            speech.add("讲话" + i);
        }
        return speech;
    }
}
