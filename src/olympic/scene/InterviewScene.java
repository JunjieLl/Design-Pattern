package olympic.scene;

import olympic.main.interview.InterviewMaker;
import olympic.main.person.interview.*;

import java.util.ArrayList;

public class InterviewScene implements Scene {
    private final Interviewee interviewee;
    private final ArrayList<Interviewer> interviewers;

    InterviewScene(Interviewee interviewee, ArrayList<Interviewer> interviewers) {
        this.interviewee = interviewee;
        this.interviewers = interviewers;
    }

    @Override
    public void play() {
        InterviewMaker.makeInterview(interviewee, interviewers);
    }
}
