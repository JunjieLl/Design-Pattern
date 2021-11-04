package olympic.main.interview.questionstrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 采访Strategy
 */
public abstract class InterviewStrategy implements QuestionStrategy {
    /**
     * 事先准备的问题
     */
    protected Queue<String> preparedQuestions = new LinkedList<>();

    /**
     * 添加新闻发布会笔记，此处什么都不做
     *
     * @param content 笔记内容
     */
    @Override
    public void addNote(String content) {
    }

    /**
     * 从事先准备好的问题中获取要问的问题
     *
     * @return 要问的问题
     */
    @Override
    public String getQuestion() {
        return preparedQuestions.poll();
    }

    /**
     * 准备要问的问题
     *
     * @param allPossibleQuestions 所有可能的问题
     */
    protected void prepareQuestions(String[] allPossibleQuestions) {
        Random random = new Random();
        ArrayList<Integer> randomIndexList = new ArrayList<>();
        int questionNum = random.nextInt(allPossibleQuestions.length - 1) + 1;
        int generatedQuestionNum = 0;
        while (generatedQuestionNum != questionNum) {
            int randomIndex = random.nextInt(allPossibleQuestions.length);
            if (!(randomIndexList.contains(randomIndex))) {
                preparedQuestions.add(allPossibleQuestions[randomIndex]);
                randomIndexList.add(randomIndex);
                generatedQuestionNum++;
            }
        }
    }

    /**
     * 判断是否还有没问题的问题（准备的问题是否问完了）
     *
     * @return 是否还有没问的问题
     */
    public boolean haveQuestion() {
        return !preparedQuestions.isEmpty();
    }
}
