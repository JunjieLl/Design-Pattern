package olympic.main.interview;

import olympic.main.interview.builder.InternetReportBuilder;
import olympic.main.interview.builder.NewspaperBuilder;
import olympic.main.interview.questionstrategy.PreInterviewStrategy;
import olympic.main.interview.questionstrategy.AfterInterviewStrategy;
import olympic.main.person.athlete.track.TrackAthlete;
import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Interviewer;

import java.util.ArrayList;
import java.util.Random;

public class InterviewMaker {
    private InterviewMaker() {

    }

    public static void makeInterview(Interviewee interviewee, ArrayList<Interviewer> interviewers) {
        for (Interviewer interviewer : interviewers) {
            interviewee.addListener(interviewer);
        }
        for (Interviewer interviewer : interviewers) {
            var reportBuilder = interviewer.getReportBuilder();
            reportBuilder.makeTitle("");
        }
        ArrayList<String> historyQuestions = new ArrayList<>();
        Interviewer currentInterviewer = pickOneInterviewer(interviewers);
        while (currentInterviewer != null) {
            String currentQuestion = currentInterviewer.ask();
            if (!historyQuestions.contains(currentQuestion)) {
                System.out.println(currentInterviewer.getName() + "问问题：" + currentQuestion);
                String currentAnswer = interviewee.answerQuestion(currentQuestion);
                interviewee.notifyListeners(currentAnswer);
                System.out.println(currentAnswer);
                historyQuestions.add(currentQuestion);
                var reportBuilder = currentInterviewer.getReportBuilder();
                reportBuilder.makeQuestion(currentQuestion);
                reportBuilder.makeAnswer(currentAnswer);
            }
            currentInterviewer = pickOneInterviewer(interviewers);
        }
        System.out.println('\n');
        for (Interviewer interviewer : interviewers) {
            var reportBuilder = interviewer.getReportBuilder();
            reportBuilder.close();
            reportBuilder.showReport();
        }
    }

    public static void main(String[] args) {
        System.out.println("赛前采访开始：");
        Interviewee preInterviewee = new TrackAthlete("徐满心", "中国");
        ArrayList<Interviewer> beforeInterviewers = new ArrayList<>();
        beforeInterviewers.add(new Interviewer("Junjie Li", "美国", new PreInterviewStrategy(), new NewspaperBuilder("Junjie Li", "Manxin Xu")));
        beforeInterviewers.add(new Interviewer("Chenhao Zhai", "英国", new PreInterviewStrategy(), new InternetReportBuilder("Chenhao Zhai", "Manxin Xu")));
        beforeInterviewers.add(new Interviewer("Even", "法国", new PreInterviewStrategy(), new InternetReportBuilder("Even", "Manxin Xu")));
        makeInterview(preInterviewee, beforeInterviewers);
        System.out.println("赛前采访结束\n");

        System.out.println("赛后采访开始：");
        Interviewee afterInterviewee = new TrackAthlete("徐满心", "中国");
        ArrayList<Interviewer> afterInterviewers = new ArrayList<>();
        afterInterviewers.add(new Interviewer("YangWanting Wu", "美国", new AfterInterviewStrategy(), new InternetReportBuilder("YangWanting Wu", "Manxin Xu")));
        afterInterviewers.add(new Interviewer("Ziyu Zhao", "英国", new AfterInterviewStrategy(), new InternetReportBuilder("Ziyu Zhao", "Manxin Xu")));
        afterInterviewers.add(new Interviewer("Lixin Luo", "法国", new AfterInterviewStrategy(), new InternetReportBuilder("Lixin Luo", "Manxin Xu")));
        makeInterview(afterInterviewee, afterInterviewers);
        System.out.println("赛后采访结束\n");
    }

    private static Interviewer pickOneInterviewer(ArrayList<Interviewer> interviewers) {
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
