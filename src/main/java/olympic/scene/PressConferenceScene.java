package olympic.scene;

import olympic.main.pressconference.*;

import java.util.*;

import olympic.main.person.interview.*;

public class PressConferenceScene implements Scene {
    private final Interviewee interviewee;
    private final List<Interviewer> interviewers;
    private final List<Listener> audience;
    private final int maxQuestionNum;

    public PressConferenceScene(Interviewee interviewee, List<Interviewer> interviewers, List<Listener> audience, int maxQuestionNum) {
        this.interviewee = interviewee;
        this.interviewers = interviewers;
        this.audience = audience;
        this.maxQuestionNum = maxQuestionNum;
    }

    @Override
    public void play() {
        PressConferenceMaker.makePressConference(interviewee, interviewers, audience, maxQuestionNum);
    }
}
