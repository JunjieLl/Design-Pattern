package olympic.main.interview;

import olympic.main.interview.builder.InternetReportBuilder;
import olympic.main.interview.builder.NewspaperBuilder;
import olympic.main.interview.questionstrategy.PreInterviewStrategy;
import olympic.main.interview.questionstrategy.AfterInterviewStrategy;
import olympic.main.person.athlete.IndividualAthlete;
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
        Interviewee preInterviewee = new IndividualAthlete("Manxin Xu", "male");
        ArrayList<Interviewer> beforeInterviewers = new ArrayList<>();
        beforeInterviewers.add(new Interviewer("Junjie Li", "male", new PreInterviewStrategy(), new NewspaperBuilder("Junjie Li", "Manxin Xu")));
        beforeInterviewers.add(new Interviewer("Chenhao Zhai", "male", new PreInterviewStrategy(), new InternetReportBuilder("Chenhao Zhai", "Manxin Xu")));
        beforeInterviewers.add(new Interviewer("Even", "female", new PreInterviewStrategy(), new InternetReportBuilder("Even", "Manxin Xu")));
        makeInterview(preInterviewee, beforeInterviewers);
        System.out.println("赛前采访结束\n");

        System.out.println("赛后采访开始：");
        Interviewee afterInterviewee = new IndividualAthlete("Manxin Xu", "male");
        ArrayList<Interviewer> afterInterviewers = new ArrayList<>();
        afterInterviewers.add(new Interviewer("YangWanting Wu", "female", new AfterInterviewStrategy(), new InternetReportBuilder("YangWanting Wu", "Manxin Xu")));
        afterInterviewers.add(new Interviewer("Ziyu Zhao", "male", new AfterInterviewStrategy(), new InternetReportBuilder("Ziyu Zhao", "Manxin Xu")));
        afterInterviewers.add(new Interviewer("Lixin Luo", "male", new AfterInterviewStrategy(), new InternetReportBuilder("Lixin Luo", "Manxin Xu")));
        makeInterview(afterInterviewee, afterInterviewers);
        System.out.println("赛后采访结束\n");
    }

    public static Interviewer pickOneInterviewer(ArrayList<Interviewer> interviewers) {
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
