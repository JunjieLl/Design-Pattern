package olympic.main.pressconference.questionstrategy;

import olympic.main.interview.questionstrategy.QuestionStrategy;

import java.util.ArrayList;
import java.util.Random;

/**
 * 新闻发布会Strategy
 */
public class PressConferenceStrategy implements QuestionStrategy {
    /**
     * 新闻发布会笔记
     */
    private final ArrayList<String> notes = new ArrayList<>();

    /**
     * 添加新闻发布会笔记
     *
     * @param content 笔记内容
     */
    @Override
    public void addNote(String content) {
        notes.add(content);
    }

    /**
     * 获取要问的问题
     *
     * @return 要问的问题
     */
    @Override
    public String getQuestion() {
        Random random = new Random();
        int randomIndex = random.nextInt(notes.size());
        String question = notes.get(randomIndex);
        notes.remove(randomIndex);
        return question;
    }

    /**
     * 判断是否还有没问的问题（笔记是否为空）
     *
     * @return 是否还有没问的问题
     */
    @Override
    public boolean haveQuestion() {
        return !notes.isEmpty();
    }
}
