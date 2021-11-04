package olympic.scene;

import olympic.Utils.PrintBlockFormat;
import olympic.main.interview.InterviewMaker;
import olympic.main.interview.builder.NewspaperBuilder;
import olympic.main.interview.questionstrategy.AfterInterviewAthleteStrategy;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.interview.Interviewer;
import olympic.main.postgame.award_ceremony.*;
import olympic.main.postgame.award_ceremony.prototype_framework.Manager;
import olympic.main.postgame.medaltable.MedalTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 颁奖仪式的场景.
 * todo: 该场景是添加到比赛中的子场景，后续合并时将提供一个由参数构造函数，参数为获奖者.
 */
public class CeremonyScene implements Scene {
    private String goldTitle;
    private String silverTitle;
    private String bronzeTitle;
    private Athlete goldPlayer;
    private Athlete silverPlayer;
    private Athlete bronzePlayer;

    public CeremonyScene(String gold, String silver, String bronze){
        this.goldTitle = gold;
        this.silverTitle = silver;
        this.bronzeTitle = bronze;
    }

    public CeremonyScene(List<Athlete> athletes){
        goldPlayer = athletes.get(0);
        silverPlayer = athletes.get(1);
        bronzePlayer = athletes.get(2);
        this.goldTitle = goldPlayer.getName() + ", TEAM " + goldPlayer.getNation();
        this.silverTitle = silverPlayer.getName() + ", TEAM " + silverPlayer.getNation();
        this.bronzeTitle = bronzePlayer.getName() + ", TEAM " + bronzePlayer.getNation();

        MedalTable.getInstance().addGold(goldPlayer.getNation());
        MedalTable.getInstance().addSilver(silverPlayer.getNation());
        MedalTable.getInstance().addBronze(bronzePlayer.getNation());
    }

    @Override
    public void play() {

        System.out.println("\nclassname: (CeremonyScene) method: (play) action: (颁奖仪式场景开始) ");
        List<String> ceremonyInitPrintBlock = new ArrayList<String>();
        ceremonyInitPrintBlock.add("颁奖仪式总流程");
        ceremonyInitPrintBlock.add("1. 展示奖牌制作过程");
        ceremonyInitPrintBlock.add("2. 为获奖者颁发奖牌");
        ceremonyInitPrintBlock.add("3. 升国旗奏国歌");
        ceremonyInitPrintBlock.add("4. 展示更新后奖牌榜");


        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatMiddleScreen(ceremonyInitPrintBlock,true);

        new MedalMaking();

        System.out.println("\nclassname: (CeremonyScene) method: (play) action: (展示奖牌场景) \n");

        List<String> ceremonyPresentPrintBlock = new ArrayList<String>();
        ceremonyPresentPrintBlock.add("颁发奖牌");
        ceremonyPresentPrintBlock.add("让我们由衷祝贺奥林匹克奖牌获得者。");
        printBlockFormat.printFormatMiddleScreen(ceremonyPresentPrintBlock,true);
        
        Manager manager = new Manager();
        new MedalPresenting(manager, goldTitle, silverTitle, bronzeTitle);

        List<String> ceremonyEndingPrintBlock = new ArrayList<String>();
        ceremonyEndingPrintBlock.add("升国旗，奏国歌");
        ceremonyEndingPrintBlock.add("请全体肃立，升"+goldPlayer.getNation()+"国旗，奏"+goldPlayer.getNation()+"国歌。");
        ceremonyEndingPrintBlock.add("本场颁奖仪式已经结束，以下为您展示最新的奖牌榜。");
        printBlockFormat.printFormatMiddleScreen(ceremonyEndingPrintBlock,true);

        List<Interviewer> ceremonyInterviewer = PersonFactory.getInstance().getInterviews();
        List<Interviewer> goldPlayerInterviewer = new ArrayList<Interviewer>();
        int interviewerIndex = new Random().nextInt(100);
        Interviewer goldInterview1 = ceremonyInterviewer.get(interviewerIndex);
        goldInterview1.setStrategy(new AfterInterviewAthleteStrategy());
        goldInterview1.setReportBuilder(new NewspaperBuilder(goldInterview1.getName(),goldPlayer.getName()));
        goldPlayerInterviewer.add(goldInterview1);
        InterviewMaker.makeInterview(goldPlayer, goldPlayerInterviewer, PersonFactory.getInstance().getAthletes("Marathon"),5);
//再加入对教练的采访
        MedalTable.getInstance().printMedalTable();
        System.out.println("\n");
    }

}

