package olympic.main.interview.questionstrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public abstract class InterviewStrategy implements QuestionStrategy {
    protected Queue<String> preparedQuestions = new LinkedList<>();

    @Override
    public void addNote(String content) {
    }

    @Override
    public String getQuestion() {
        return preparedQuestions.poll();
    }

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

    public boolean haveQuestion() {
        return !preparedQuestions.isEmpty();
    }
}
