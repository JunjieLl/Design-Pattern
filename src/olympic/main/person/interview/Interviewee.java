package olympic.main.person.interview;

import olympic.main.person.Person;

import java.util.ArrayList;

public abstract class Interviewee extends Person implements Listener {
    private final ArrayList<Listener> listeners = new ArrayList<>();

    protected Interviewee(String name, String gender) {
        super(name, gender);
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
        String answer = this.name + "回答问题：" + content;
        notifyListeners(answer);
        return answer;
    }

    public void notifyListeners(String content) {
        for (Listener o : listeners) {
            o.update(content);
        }
    }
}
