package olympic.main.interview.questionstrategy;

/**
 * 赛后采访运动员Strategy
 */
public class AfterInterviewAthleteStrategy extends InterviewStrategy {
    /**
     * 赛后采访运动员所有可能问的问题
     */
    private static final String[] allPossibleQuestions = {
            "给大家打个招呼吧！",
            "今天自己发挥如何？",
            "今天对手发挥如何？",
            "有什么想对自己的粉丝说的？",
            "现在心情怎么样？"
    };

    /**
     * 构建赛后采访运动员Strategy
     */
    public AfterInterviewAthleteStrategy() {
        super();
        prepareQuestions(allPossibleQuestions);
    }
}
