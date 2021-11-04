package olympic.main.interview.questionstrategy;

public class AfterInterviewCoachStrategy extends InterviewStrategy{

    private static final String[] allPossibleQuestions = {
            "给大家打个招呼吧！",
            "觉得今天自己执教的队员们发挥得怎样？",
            "对自己执教的这支队伍的期待是什么？",
            "有什么想对自己的粉丝说的？",
            "现在心情怎么样？"
    };

    public AfterInterviewCoachStrategy() {
        super();
        prepareQuestions(allPossibleQuestions);
    }
}
