package olympic.main.interview.questionstrategy;

/**
 * 赛前采访运动员Strategy
 */
public class PreInterviewAthleteStrategy extends InterviewStrategy {
    /**
     * 赛前采访运动员所有可能问的问题
     */
    private static final String[] allPossibleQuestions = {
            "给大家打个招呼吧！",
            "你对对手有什么想说的？",
            "你觉得谁最可能夺冠？",
            "今天状态如何？",
            "对自己的期待是什么？"
    };

    /**
     * 构建赛前采访运动员Strategy
     */
    public PreInterviewAthleteStrategy() {
        super();
        prepareQuestions(allPossibleQuestions);
    }
}
