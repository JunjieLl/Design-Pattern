package olympic.main.postgame.review_qualification;

import olympic.main.person.athlete.Athlete;
import olympic.main.postgame.medaltable.MedalTable;

import java.util.ArrayList;

/**
 * 具体的仲裁者，继承自仲裁者接口.
 */
public class ReviewMediatorConcrete implements ReviewMediator{
    private ReviewColleagueEvidence rcecidence;
    private ReviewColleagueInvestigation rcinvestigate;
    private ReviewColleagueEvaluation rcevauluate;
    private Athlete badAthlete;
    private String targetGame;
    private int round;
    public ReviewMediatorConcrete(Athlete badAthlete, String game){
        round=0;
        this.badAthlete = badAthlete;
        this.targetGame = game;
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
            System.out.println("【调查管理员】本委员会即将对在 "+ targetGame +" 比赛中，该运动员："+ badAthlete.getName() + "的违纪检察");
            System.out.println("【调查管理员】比赛获奖资质调查已经启动，已经向取证小组发送指令。");
            rcecidence.collectEvidence();
        } else if (event == "RNG"){
            round+=1;
            if(round<2){
                System.out.println("【调查管理员】正在安排取证小组进行新一轮取证。");
                rcecidence.collectEvidence();
            }
            else{
                System.out.println("【调查管理员】根据我们掌握的证据、严谨的调查和审慎的评估，在 "+ targetGame +" 比赛中，该运动员：");
                System.out.println("【调查管理员】"+badAthlete.getName()+", "+"来自："+badAthlete.getNation());
                System.out.println("【调查管理员】有严重违纪行为，我们将会取消其奖牌资格。奥林匹克委员会坚决维护比赛的公平公正性。");

                ArrayList<String> PingpongDiving = new ArrayList<>();
                PingpongDiving.add("Pingpong");
                PingpongDiving.add("Diving");

                if (PingpongDiving.contains(targetGame)) {
                    MedalTable.getInstance().penalty(badAthlete.getNation(), badAthlete.getRank("决赛"));
                } else{
                    MedalTable.getInstance().penalty(badAthlete.getNation(), badAthlete.getRank(targetGame));
                }

                MedalTable.getInstance().printMedalTable();
            }

        } else if (event == "RG"){
            System.out.println("【调查管理员】调查完毕，未发现异常。感谢您对奥运比赛公正性的关注。");
        } else{
            System.out.println("【调查管理员】资质调查小组已处于待命状态。");
        }
    }
}
