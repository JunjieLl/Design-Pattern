package olympic.main.person.interview;

import olympic.main.person.Person;

/**
 * 控制采访与新闻发布会的停止
 */
public class Stopper extends Person implements Listener {
    private final int maxQuestionNum;
    private int currentQuestionNum = 0;

    public Stopper(String name, String nation, int maxQuestionNum) {
        super(name, nation);
        this.maxQuestionNum = maxQuestionNum;
    }

    @Override
    public void update(String content) {
        memory.add(content);
        currentQuestionNum++;
        if (content.equals(Interviewee.STOP_WORD)) {
            currentQuestionNum = maxQuestionNum;
        }
    }

    public boolean shouldStop() {
        return currentQuestionNum >= maxQuestionNum;
    }
}
