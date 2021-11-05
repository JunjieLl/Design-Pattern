package olympic.main.postgame.reviewqualification;

import olympic.utils.PrintBlockFormat;
import olympic.main.person.athlete.Athlete;
import olympic.main.postgame.medaltable.MedalTable;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的仲裁者，继承自仲裁者接口.
 */
public class ReviewMediatorConcrete implements ReviewMediator {
    /**
     * 该仲裁者管理的取证小组
     */
    private ReviewColleagueEvidence rcevidence;

    /**
     * 该仲裁者管理的调查小组
     */
    private ReviewColleagueInvestigation rcinvestigate;

    /**
     * 该仲裁者管理的评估小组
     */
    private ReviewColleagueEvaluation rcevaluate;

    /**
     * 调查的对象
     */
    private final Athlete badAthlete;

    /**
     * 出现问题的比赛
     */
    private final String targetGame;


    /**
     * 取证和调查的轮次
     */
    private int round;

    /**
     * @param badAthlete 调查对象
     * @param game       出现问题的比赛名
     */
    public ReviewMediatorConcrete(Athlete badAthlete, String game) {
        round = 0;
        this.badAthlete = badAthlete;
        this.targetGame = game;
        createColleagues();
        colleagueChanged("INIT");
    }

    /**
     * 生成各个工作小组
     */
    @Override
    public void createColleagues() {
        rcevidence = new ReviewColleagueEvidence();
        rcinvestigate = new ReviewColleagueInvestigation();
        rcevaluate = new ReviewColleagueEvaluation();
        rcevidence.setMediator(this);
        rcinvestigate.setMediator(this);
        rcevaluate.setMediator(this);
    }

    /**
     * 根据不同的事件进行相应的响应.
     *
     * @param event 发生的事件
     */
    @Override
    public void colleagueChanged(String event) {
        System.out.println("\nclassname: (ReviewMediatorConcrete) method: (colleagueChanged) action: (仲裁者模式仲裁者响应各小组汇报，安排新的任务) ");
        switch (event) {
            case "EC":
                rcinvestigate.conductInvestigation();
                break;
            case "IC": {
                List<String> mediatorICEventPrintBlock = new ArrayList<>();
                mediatorICEventPrintBlock.add("调查管理员");
                mediatorICEventPrintBlock.add("已收到调查结果，正在安排评估小组讨论评估。");
                PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
                printBlockFormat.printFormatLeftScreen(mediatorICEventPrintBlock, true);
                rcevaluate.conductEvaluation();
                break;
            }
            case "INIT": {
                List<String> mediatorInitEventPrintBlock = new ArrayList<>();
                mediatorInitEventPrintBlock.add("调查管理员");
                mediatorInitEventPrintBlock.add("本委员会即将对在 " + targetGame + " 比赛中，该运动员：" + badAthlete.getName() + "的违纪检察");
                mediatorInitEventPrintBlock.add("比赛获奖资质调查已经启动，已经向取证小组发送指令。");
                PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
                printBlockFormat.printFormatLeftScreen(mediatorInitEventPrintBlock, true);
                rcevidence.collectEvidence();
                break;
            }
            case "RNG":
                round += 1;
                if (round < 2) {
                    List<String> mediatorRNGEventPrintBlock1 = new ArrayList<>();
                    mediatorRNGEventPrintBlock1.add("调查管理员");
                    mediatorRNGEventPrintBlock1.add("针对当前结果，本委员会即将安排新一轮取证和调查。");

                    PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
                    printBlockFormat.printFormatLeftScreen(mediatorRNGEventPrintBlock1, true);

                    rcevidence.collectEvidence();
                } else {
                    List<String> mediatorRNGEventPrintBlock2 = new ArrayList<>();
                    mediatorRNGEventPrintBlock2.add("调查管理员");
                    mediatorRNGEventPrintBlock2.add("根据我们掌握的证据、严谨的调查和审慎的评估，在 " + targetGame + " 比赛中，该运动员：");
                    mediatorRNGEventPrintBlock2.add(badAthlete.getName() + ", " + "来自：" + badAthlete.getNation());
                    mediatorRNGEventPrintBlock2.add("有严重违纪行为，我们将会取消其奖牌资格。奥林匹克委员会坚决维护比赛的公平公正性。");

                    PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
                    printBlockFormat.printFormatLeftScreen(mediatorRNGEventPrintBlock2, true);


                    ArrayList<String> PingpongDiving = new ArrayList<>();
                    PingpongDiving.add("Pingpong");
                    PingpongDiving.add("Diving");

                    if (PingpongDiving.contains(targetGame)) {
                        MedalTable.getInstance().penalty(badAthlete.getNation(), badAthlete.getRank("决赛"));
                        badAthlete.setRank("决赛", -1);
                    } else {
                        MedalTable.getInstance().penalty(badAthlete.getNation(), badAthlete.getRank(targetGame));
                        badAthlete.setRank(targetGame, -1);
                    }

                    MedalTable.getInstance().printMedalTable();
                }

                break;
            case "RG": {
                List<String> mediatorRGEventPrintBlock = new ArrayList<>();
                mediatorRGEventPrintBlock.add("调查管理员");
                mediatorRGEventPrintBlock.add("调查完毕，未发现异常。感谢您对奥运比赛公正性的关注。");
                PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
                printBlockFormat.printFormatLeftScreen(mediatorRGEventPrintBlock, true);

                break;
            }
            default: {
                List<String> mediatorReadyEventPrintBlock = new ArrayList<>();
                mediatorReadyEventPrintBlock.add("调查管理员");
                mediatorReadyEventPrintBlock.add("调查管理员处于待命状态。");
                PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
                printBlockFormat.printFormatLeftScreen(mediatorReadyEventPrintBlock, true);
                break;
            }
        }
    }
}