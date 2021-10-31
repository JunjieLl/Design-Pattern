package olympic.scene;

import olympic.main.pressconference.*;
import java.util.*;
import olympic.main.person.interview.*;

public class PressConferenceScene implements Scene {
    private final Interviewee interviewee;
    private final ArrayList<Interviewer> interviewers;
    private final int maxQuestionNum;

    public PressConferenceScene(Interviewee interviewee, ArrayList<Interviewer> interviewers, int maxQuestionNum) {
        this.interviewee = interviewee;
        this.interviewers = interviewers;
        this.maxQuestionNum = maxQuestionNum;
    }

    @Override
    public void play() {
        PressConferenceMaker.makePressConference(interviewee, interviewers, maxQuestionNum);
    }
}
