package olympic.main.pressconference;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.track.TrackAthlete;
import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Interviewer;
import olympic.main.pressconference.questionstrategy.PressConferenceStrategy;

import java.util.ArrayList;
import java.util.Random;

public class PressConferenceMaker {
    private PressConferenceMaker() {

    }

    public static void makePressConference(Interviewee interviewee, ArrayList<Interviewer> interviewers, int maxQuestionNum) {
        for (Interviewer interviewer : interviewers) {
            interviewee.addListener(interviewer);
        }
        ArrayList<String> speech = interviewee.makeSpeech();
        for (String talk : speech) {
            System.out.println(interviewee.getName() + "发表" + talk);
            interviewee.notifyListeners(talk);
        }
        int askedNum = 0;
        while (askedNum != maxQuestionNum && !notesEmpty(interviewers)) {
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
            System.out.println(currentAnswer);
            askedNum++;
        }
    }

    public static void main(String[] args) {
        System.out.println("新闻发布会开始：");
        Interviewee interviewee = new TrackAthlete("Manxin Xu", "male");
        ArrayList<Interviewer> interviewers = new ArrayList<>();
        interviewers.add(new Interviewer("Junjie Li", "male", new PressConferenceStrategy()));
        interviewers.add(new Interviewer("Chenhao Zhai", "male", new PressConferenceStrategy()));
        interviewers.add(new Interviewer("Even", "female", new PressConferenceStrategy()));
        makePressConference(interviewee, interviewers, 10);
        System.out.println("新闻发布会结束\n");
    }

    private static boolean notesEmpty(ArrayList<Interviewer> interviewers) {
        for (Interviewer interviewer : interviewers) {
            if (interviewer.haveQuestion()) {
                return false;
            }
        }
        return true;
    }
}
