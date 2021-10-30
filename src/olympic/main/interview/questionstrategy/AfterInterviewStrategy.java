package olympic.main.interview.questionstrategy;

public class AfterInterviewStrategy extends InterviewStrategy {
    private static final String[] allPossibleQuestions = {
            "给大家打个招呼吧!",
            "今天自己发挥如何？",
            "今天对手发挥如何？",
            "有什么想对自己的粉丝说的？",
            "现在心情怎么样？"
    };

    public AfterInterviewStrategy() {
        super();
        prepareQuestions(allPossibleQuestions);
    }
}
