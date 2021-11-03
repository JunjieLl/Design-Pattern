package olympic.main.postgame.review_qualification;

/**
 * 取证小组，负责收集证据.
 */
public class ReviewColleagueEvidence implements ReviewColleague {
    private ReviewMediator mediator;

    /**
     * @param mediator 注册的仲裁者.
     */
    @Override
    public void setMediator(ReviewMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 取证小组的工作函数.
     */
    public void collectEvidence() {
        System.out.println("\nclassname: (ReviewColleagueEvidence) method: (collectEvidence) action: (被仲裁者传唤，收集证据) ");
        System.out.println("【取证小组】已经接到指令，正在取证...");
        System.out.println("【取证小组】已经收集证据。");
        mediator.colleagueChanged("EC"); //Evidence collected
    }

}
