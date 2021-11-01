package olympic.main.pressconference;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.track.TrackAthlete;
import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Interviewer;
import olympic.main.person.interview.Listener;
import olympic.main.person.interview.Stopper;
import olympic.main.pressconference.questionstrategy.PressConferenceStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 安排一场新闻发布会
 * 使用的设计模式：
 * 1. Facade
 * 2. Strategy
 */
public abstract class PressConferenceMaker {
    /**
     * 安排一场新闻发布会对外暴露的API
     * 使用了Facade模式
     *
     * @param interviewee    被采访者
     * @param interviewers   采访者
     * @param audience       听众
     * @param maxQuestionNum 最大问题数
     */
    public static void makePressConference(Interviewee interviewee, List<Interviewer> interviewers, List<? extends Listener> audience, int maxQuestionNum) {
        for (Interviewer interviewer : interviewers) {
            interviewee.addListener(interviewer);
        }
        for (Listener listener : audience) {
            interviewee.addListener(listener);
        }
        List<String> speech = interviewee.makeSpeech();
        for (String talk : speech) {
            System.out.println(interviewee.getName() + "发表" + talk);
            interviewee.notifyListeners(talk);
        }
        Stopper stopper = new Stopper("宅尘浩", "中国", maxQuestionNum);
        interviewee.addListener(stopper);
        int askedNum = 0;
        while (!stopper.shouldStop() && !notesEmpty(interviewers)) {
            Random random = new Random();
            int randomIndex = random.nextInt(interviewers.size());
            while (!interviewers.get(randomIndex).haveQuestion()) {
                randomIndex = random.nextInt(interviewers.size());
            }
            Interviewer currentInterviewer = interviewers.get(randomIndex);
            String currentQuestion = currentInterviewer.ask();
            currentQuestion = "记者" + currentInterviewer.getName() + "对" + currentQuestion + "发起提问（问题" + (askedNum + 1) + "）";
            System.out.println(currentQuestion);
            String currentAnswer = interviewee.answerQuestion(currentQuestion);
            interviewee.notifyListeners(interviewee.getName() + "对问题" + (askedNum + 1) + "的回答");
            System.out.println(interviewee.getName() + "回答问题：" + currentAnswer);
            askedNum++;
        }
    }

    public static void main(String[] args) {
        // 获取听众
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        System.out.println(gameNames);
        String gameName = gameNames.get(2);
        List<? extends Listener> audience = personFactory.getAthletes(gameName);

        // 获取被采访者、采访者
        Interviewee interviewee = new TrackAthlete("徐满心", "中国");
        ArrayList<Interviewer> interviewers = new ArrayList<>();
        interviewers.add(new Interviewer("Junjie Li", "美国", new PressConferenceStrategy()));
        interviewers.add(new Interviewer("Chenhao Zhai", "英国", new PressConferenceStrategy()));
        interviewers.add(new Interviewer("Even", "法国", new PressConferenceStrategy()));

        // 新闻发布会
        System.out.println("新闻发布会开始：");
        makePressConference(interviewee, interviewers, audience, 10);
        System.out.println("新闻发布会结束\n");
    }

    /**
     * 判断采访者笔记是否为空（无问题可问）
     * @param interviewers 采访者列表
     * @return 采访笔记是否为空
     */
    private static boolean notesEmpty(List<Interviewer> interviewers) {
        for (Interviewer interviewer : interviewers) {
            if (interviewer.haveQuestion()) {
                return false;
            }
        }
        return true;
    }
}
