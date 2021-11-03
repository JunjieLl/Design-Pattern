package olympic.main.postgame.review_qualification;

/**
 * 调查小组，负责根据证据进行调查.
 */
public class ReviewColleagueInvestigation implements ReviewColleague{
    private ReviewMediator mediator;

    /**
     * @param mediator 注册的仲裁者.
     */
    @Override
    public void setMediator(ReviewMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 调查小组的工作函数.
     */
    public void conductInvestigation(){
        System.out.println("\nclassname: (ReviewColleagueInvestigation) method: (conductInvestigation) action: (被仲裁者传唤，对证据展开调查) ");
        System.out.println("【调查小组】调查小组根据证据已经进行了调查。");
        mediator.colleagueChanged("IC"); //Investigation conducted
    }
}
