package olympic.main.interview;

import olympic.main.interview.builder.InternetReportBuilder;
import olympic.main.interview.builder.NewspaperBuilder;
import olympic.main.interview.questionstrategy.PreInterviewAthleteStrategy;
import olympic.main.interview.questionstrategy.AfterInterviewAthleteStrategy;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.track.TrackAthlete;
import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Interviewer;
import olympic.main.person.interview.Listener;
import olympic.main.person.interview.Stopper;

import java.util.*;
import java.util.Random;

/**
 * 安排一场采访
 * 使用的设计模式：
 * 1. Facade
 * 2. Strategy
 * 3. Builder
 */
public abstract class InterviewMaker {
    /**
     * 安排一场采访对外暴露的API
     * 使用了Facade模式
     *
     * @param interviewee    被采访者
     * @param interviewers   采访者
     * @param audience       听众
     * @param maxQuestionNum 最大问题数
     */
    public static void makeInterview(Interviewee interviewee, List<Interviewer> interviewers, List<? extends Listener> audience, int maxQuestionNum) {
        // 添加采访者、听众、Stopper作为observer
        for (Interviewer interviewer : interviewers) {
            interviewee.addListener(interviewer);
        }
        for (Listener listener : audience) {
            interviewee.addListener(listener);
        }
        Stopper stopper = new Stopper("宅尘浩", "中国", maxQuestionNum);
        interviewee.addListener(stopper);

        // Builder模式，创建report标题
        for (Interviewer interviewer : interviewers) {
            var reportBuilder = interviewer.getReportBuilder();
            reportBuilder.makeTitle("");
        }

        // 用于记录已经提问的问题，防止重复提问
        ArrayList<String> historyQuestions = new ArrayList<>();

        // 随机抽取记者轮流提问，直到达到提问数量上限或者记者无问题可问
        Interviewer currentInterviewer = pickOneInterviewer(interviewers);
        while (stopper.shouldContinue() && currentInterviewer != null) {
            String currentQuestion = currentInterviewer.ask();
            if (!historyQuestions.contains(currentQuestion)) {
                System.out.println(currentInterviewer.getName() + "问问题：" + currentQuestion);
                String currentAnswer = interviewee.answerQuestion(currentQuestion);
                interviewee.notifyListeners(currentAnswer);
                System.out.println(interviewee.getName() + "回答问题：" + currentAnswer);
                historyQuestions.add(currentQuestion);
                var reportBuilder = currentInterviewer.getReportBuilder();
                reportBuilder.makeQuestion(currentQuestion);
                reportBuilder.makeAnswer(currentAnswer);
            }
            currentInterviewer = pickOneInterviewer(interviewers);
        }
        System.out.println('\n');

        // 攥写采访报告
        for (Interviewer interviewer : interviewers) {
            var reportBuilder = interviewer.getReportBuilder();
            reportBuilder.close();
            reportBuilder.showReport();
        }
    }

    /**
     * 安排采访功能的使用示例
     *
     * @param args 无需指定
     */
    public static void main(String[] args) {
        // 获取听众
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        System.out.println(gameNames);
        String gameName = gameNames.get(1);
        List<? extends Listener> audience = personFactory.getAthletes(gameName);

        // 赛前采访
        // 获取被采访者、采访者
        System.out.println("赛前采访开始：");
        Interviewee preInterviewee = new TrackAthlete("徐满心", "中国");
        List<Interviewer> beforeInterviewers = new ArrayList<>();
        beforeInterviewers.add(new Interviewer("Junjie Li", "美国", new PreInterviewAthleteStrategy(), new NewspaperBuilder("Junjie Li", "Manxin Xu")));
        beforeInterviewers.add(new Interviewer("Chenhao Zhai", "英国", new PreInterviewAthleteStrategy(), new InternetReportBuilder("Chenhao Zhai", "Manxin Xu")));
        beforeInterviewers.add(new Interviewer("Even", "法国", new PreInterviewAthleteStrategy(), new InternetReportBuilder("Even", "Manxin Xu")));
        // 采访
        makeInterview(preInterviewee, beforeInterviewers, audience, 10);
        System.out.println("赛前采访结束\n");

        // 赛后采访
        // 获取被采访者、采访者
        System.out.println("赛后采访开始：");
        Interviewee afterInterviewee = new TrackAthlete("徐满心", "中国");
        List<Interviewer> afterInterviewers = new ArrayList<>();
        afterInterviewers.add(new Interviewer("YangWanting Wu", "美国", new AfterInterviewAthleteStrategy(), new InternetReportBuilder("YangWanting Wu", "Manxin Xu")));
        afterInterviewers.add(new Interviewer("Ziyu Zhao", "英国", new AfterInterviewAthleteStrategy(), new InternetReportBuilder("Ziyu Zhao", "Manxin Xu")));
        afterInterviewers.add(new Interviewer("Lixin Luo", "法国", new AfterInterviewAthleteStrategy(), new InternetReportBuilder("Lixin Luo", "Manxin Xu")));
        // 采访
        makeInterview(afterInterviewee, afterInterviewers, audience, 10);
        System.out.println("赛后采访结束\n");
    }

    /**
     * 随机挑选一个采访者提问
     *
     * @param interviewers 采访者列表
     * @return 挑选出的采访者
     */
    private static Interviewer pickOneInterviewer(List<Interviewer> interviewers) {
        boolean haveQuestion = false;
        for (Interviewer interviewer :
                interviewers) {
            if (interviewer.haveQuestion()) {
                haveQuestion = true;
                break;
            }
        }
        if (!haveQuestion) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(interviewers.size());
        while (!interviewers.get(randomIndex).haveQuestion()) {
            randomIndex = random.nextInt(interviewers.size());
        }
        return interviewers.get(randomIndex);
    }
}
