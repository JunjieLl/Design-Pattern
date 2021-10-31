package olympic.scene;

import olympic.main.interview.InterviewMaker;
import olympic.main.person.interview.*;

import java.util.List;

public class InterviewScene implements Scene {
    private final List<Interviewee> interviewees;
    private final List<Interviewer> interviewers;

    InterviewScene(List<Interviewee> interviewee, List<Interviewer> interviewers) {
        this.interviewees = interviewee;
        this.interviewers = interviewers;
    }

    @Override
    public void play() {
        InterviewMaker.makeInterview(interviewees, interviewers);
    }
}
