package olympic.scene;

import olympic.main.interview.InterviewMaker;
import olympic.main.person.interview.*;

import java.util.*;

public class InterviewScene implements Scene {
    private final Interviewee interviewee;
    private final List<Interviewer> interviewers;
    private final List<? extends Listener> audience;
    private final int maxQuestionNum;

    InterviewScene(Interviewee interviewee, List<Interviewer> interviewers) {
        this(interviewee, interviewers, new ArrayList<>());
    }

    InterviewScene(Interviewee interviewee, List<Interviewer> interviewers, List<? extends Listener> audience) {
        this(interviewee, interviewers, audience, 10);
    }

    InterviewScene(Interviewee interviewee, List<Interviewer> interviewers, List<? extends Listener> audience, int maxQuestionNum) {
        this.interviewee = interviewee;
        this.interviewers = interviewers;
        this.audience = audience;
        this.maxQuestionNum = maxQuestionNum;
    }

    @Override
    public void play() {
        InterviewMaker.makeInterview(interviewee, interviewers, audience, maxQuestionNum);
    }
}
