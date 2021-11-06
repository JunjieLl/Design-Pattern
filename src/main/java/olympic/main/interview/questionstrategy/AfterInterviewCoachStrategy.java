package olympic.main.interview.questionstrategy;

/**
 * 赛后采访教练Strategy
 */
public class AfterInterviewCoachStrategy extends InterviewStrategy{
    /**
     * 赛后采访教练所有可能问的问题
     */
    private static final String[] allPossibleQuestions = {
            "给大家打个招呼吧！",
            "觉得今天自己执教的队员们发挥得怎样？",
            "对自己执教的这支队伍的期待是什么？",
            "有什么想对自己的粉丝说的？",
            "现在心情怎么样？"
    };

    /**
     * 构建赛后采访教练Strategy
     */
    public AfterInterviewCoachStrategy() {
        super();
        prepareQuestions(allPossibleQuestions);
    }
}
