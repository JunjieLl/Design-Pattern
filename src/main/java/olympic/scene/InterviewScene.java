package olympic.scene;

import olympic.main.interview.InterviewMaker;
import olympic.main.person.interview.*;

import java.util.*;

/**
 * 采访场景
 */
public class InterviewScene implements Scene {

    /**
     * 被采访者
     */
    private final Interviewee interviewee;

    /**
     * 采访者
     */
    private final List<Interviewer> interviewers;

    /**
     * 观众
     */
    private final List<? extends Listener> audience;

    /**
     * 最大问题数
     */
    private final int maxQuestionNum;

    /**
     * 构造函数
     * @param interviewee 被采访者
     * @param interviewers 采访者
     */
    InterviewScene(Interviewee interviewee, List<Interviewer> interviewers) {
        this(interviewee, interviewers, new ArrayList<>());
    }

    /**
     * 构造函数
     * @param interviewee 被采访者
     * @param interviewers 采访者
     * @param audience 观众
     */
    InterviewScene(Interviewee interviewee, List<Interviewer> interviewers, List<? extends Listener> audience) {
        this(interviewee, interviewers, audience, 10);
    }

    /**
     * 构造函数
     * @param interviewee 被采访者
     * @param interviewers 采访者
     * @param audience 观众
     * @param maxQuestionNum 最大问题数
     */
    InterviewScene(Interviewee interviewee, List<Interviewer> interviewers, List<? extends Listener> audience, int maxQuestionNum) {
        this.interviewee = interviewee;
        this.interviewers = interviewers;
        this.audience = audience;
        this.maxQuestionNum = maxQuestionNum;
    }


    /**
     * 运行场景
     */
    @Override
    public void play() {
        InterviewMaker.makeInterview(interviewee, interviewers, audience, maxQuestionNum);
    }
}
