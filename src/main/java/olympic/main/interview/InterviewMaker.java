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
 * 4. Observer
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
        System.out.println("classname: (InterviewMaker) method: (makeInterview) action: (举办一场采访，使用了Facade模式、Observer模式与Strategy模式)");
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

        System.out.println("classname: (ReportBuilder) method: (showReport) action: (攥写采访报告，使用了Builder模式)");
        // 攥写采访报告
        for (Interviewer interviewer : interviewers) {
            var reportBuilder = interviewer.getReportBuilder();
            reportBuilder.close();
            reportBuilder.showReport();
        }
    }

    /**
     * 随机挑选一个采访者提问
     *
     * @param interviewers 采访者列表
     * @return 挑选出的采访者
     */
    public static Interviewer pickOneInterviewer(List<Interviewer> interviewers) {
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
