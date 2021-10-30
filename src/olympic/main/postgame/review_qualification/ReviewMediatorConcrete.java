package olympic.main.postgame.review_qualification;

/**
 * 具体的仲裁者，继承自仲裁者接口.
 */
public class ReviewMediatorConcrete implements ReviewMediator{
    private ReviewColleagueEvidence rcecidence;
    private ReviewColleagueInvestigation rcinvestigate;
    private ReviewColleagueEvaluation rcevauluate;
    public ReviewMediatorConcrete(){
        createColleagues();
        colleagueChanged("INIT");
    }

    @Override
    public void createColleagues() {
        rcecidence = new ReviewColleagueEvidence();
        rcinvestigate = new ReviewColleagueInvestigation();
        rcevauluate = new ReviewColleagueEvaluation();
        rcecidence.setMediator(this);
        rcinvestigate.setMediator(this);
        rcevauluate.setMediator(this);
    }

    /**
     * 根据不同的事件进行相应的响应.
     * @param event 发生的事件
     */
    @Override
    public void colleagueChanged(String event) {
        System.out.println("\nclassname: (ReviewMediatorConcrete) method: (colleagueChanged) action: (仲裁者响应各小组汇报，安排新的任务) ");
        if(event=="EC"){
            rcinvestigate.conductInvestigation();
        } else if (event == "IC"){
            System.out.println("【调查管理员】已收到调查结果，正在安排评估小组讨论评估。");
            rcevauluate.conductEvalution();
        } else if (event == "INIT") {
            System.out.println("【调查管理员】比赛获奖资质调查已经启动，已经向取证小组发送指令。");
            rcecidence.collectEvidence();
        } else if (event == "RNG"){
            System.out.println("【调查管理员】正在安排取证小组进行新一轮取证。");
            rcecidence.collectEvidence();
        } else if (event == "RG"){
            System.out.println("【调查管理员】调查完毕，未发现异常。感谢您对奥运比赛公正性的关注。");
        } else{
            System.out.println("【调查管理员】资质调查小组已处于待命状态。");
        }
    }
}
