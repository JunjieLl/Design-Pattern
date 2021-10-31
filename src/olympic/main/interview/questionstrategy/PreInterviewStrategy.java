package olympic.main.interview.questionstrategy;

public class PreInterviewStrategy extends InterviewStrategy {
    private static final String[] allPossibleQuestions = {
            "给大家打个招呼吧!",
            "你对对手有什么想说的？",
            "你觉得谁最可能夺冠？",
            "今天状态如何？",
            "对自己的期待是什么？"
    };

    public PreInterviewStrategy() {
        super();
        prepareQuestions(allPossibleQuestions);
    }
}
