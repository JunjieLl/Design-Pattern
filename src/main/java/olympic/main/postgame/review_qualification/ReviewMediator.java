package olympic.main.postgame.review_qualification;

/**
 * 定义仲裁者的接口.
 */
public interface ReviewMediator {

    /**
     * 生成Mediator要管理的组员.
     */
    void createColleagues();

    /**
     * 组员完成工作向仲裁者汇报完成的事件.
     *
     * @param event 发生的事件
     */
    void colleagueChanged(String event);
}
