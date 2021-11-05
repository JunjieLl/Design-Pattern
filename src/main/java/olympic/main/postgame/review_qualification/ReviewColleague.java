package olympic.main.postgame.review_qualification;

/**
 * 定义合作者的接口。
 */
public interface ReviewColleague {

    /**
     * 为合作者注册仲裁者.
     *
     * @param mediator 完成该任务对应的仲裁者.
     */
    public abstract void setMediator(ReviewMediator mediator);
}
