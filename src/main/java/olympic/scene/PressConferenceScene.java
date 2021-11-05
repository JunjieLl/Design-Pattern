package olympic.scene;

import olympic.main.pressconference.*;

import java.util.*;

import olympic.main.person.interview.*;

/**
 * 新闻发布会场景
 */
public class PressConferenceScene implements Scene {
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
     * @param interviewee 被采访 者
     * @param interviewers 采访者
     * @param audience 观众
     * @param maxQuestionNum 最大问题数
     */
    public PressConferenceScene(Interviewee interviewee, List<Interviewer> interviewers, List<? extends Listener> audience, int maxQuestionNum) {
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
        PressConferenceMaker.makePressConference(interviewee, interviewers, audience, maxQuestionNum);
    }
}
