package olympic.scene;

import olympic.Utils.PrintBlockFormat;
import olympic.main.interview.InterviewMaker;
import olympic.main.interview.builder.InternetReportBuilder;
import olympic.main.interview.builder.NewspaperBuilder;
import olympic.main.interview.questionstrategy.AfterInterviewAthleteStrategy;
import olympic.main.interview.questionstrategy.AfterInterviewCoachStrategy;
import olympic.main.opening.deliverSpeech.Coach;
import olympic.main.person.NameFactory;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.interview.Interviewer;
import olympic.main.postgame.award_ceremony.*;
import olympic.main.postgame.award_ceremony.prototype_framework.Manager;
import olympic.main.postgame.medaltable.MedalTable;
import olympic.main.pressconference.PressConferenceMaker;
import olympic.main.pressconference.questionstrategy.PressConferenceStrategy;
import olympic.picture.OutputPicture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
        List<String> ceremonyInitPrintBlock = new ArrayList<>();
        ceremonyInitPrintBlock.add("颁奖仪式完整流程");
        ceremonyInitPrintBlock.add("1. 展示奖牌制作过程");
        ceremonyInitPrintBlock.add("2. 赛后采访");
        ceremonyInitPrintBlock.add("3. 新闻发布会");
        ceremonyInitPrintBlock.add("4. 为获奖者颁发奖牌");
        ceremonyInitPrintBlock.add("5. 升国旗奏国歌");
        ceremonyInitPrintBlock.add("6. 展示更新后奖牌榜");

        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatMiddleScreen(ceremonyInitPrintBlock,true);

        showDetail();

        System.out.println("\nclassname: (CeremonyScene) method: (play) action: (展示奖牌场景) \n");

        List<String> ceremonyPresentPrintBlock = new ArrayList<>();
        ceremonyPresentPrintBlock.add("颁发奖牌");
        ceremonyPresentPrintBlock.add("让我们由衷祝贺奥林匹克奖牌获得者。");
        printBlockFormat.printFormatMiddleScreen(ceremonyPresentPrintBlock,true);
        
        Manager manager = new Manager();
        new MedalPresenting(manager, goldTitle, silverTitle, bronzeTitle);

        List<String> ceremonyEndingPrintBlock = new ArrayList<>();
        ceremonyEndingPrintBlock.add("升国旗，奏国歌");
        ceremonyEndingPrintBlock.add("请全体肃立，升"+NameFactory.getChineseNaitonName(goldPlayer.getNation())+"国旗，奏"+NameFactory.getChineseNaitonName(goldPlayer.getNation())+"国歌。");
        ceremonyEndingPrintBlock.add("本场颁奖仪式已经结束。");
        printBlockFormat.printFormatMiddleScreen(ceremonyEndingPrintBlock,true);

        List<String> medalTableInitPrintBlock = new ArrayList<>();
        medalTableInitPrintBlock.add("奖牌榜");
        medalTableInitPrintBlock.add("以下是目前的奖牌榜");
        printBlockFormat.printFormatMiddleScreen(medalTableInitPrintBlock,true);

        MedalTable.getInstance().printMedalTable();
        System.out.println("\n");
    }

    private void buildMedalMakingProcedure(){
        new MedalMaking();
    }

    private void printHelp(){
        List<String> strings = new ArrayList<>();
        strings.add("请输入您的选择");
        strings.add("1. 查看奖牌制作过程");
        strings.add("2. 观看采访");
        strings.add("3. 观看新闻发布会");
        strings.add("4. 完整展示");
        strings.add("其他输入仅观赏颁奖典礼");
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(strings, true);
    }

    private void showDetail(){
        printHelp();
        Scanner scanner = new Scanner(System.in);
        String str;
        boolean flag = true;
        while(flag){
            System.out.println("[您的选择]");
            str = scanner.nextLine();
            if(str.equals("1")){
                buildMedalMakingProcedure();
                flag = false;
            }else if(str.equals("2")){
                OutputPicture.printPictureOf(12);
                buildInterview();
                flag = false;
            }else if(str.equals("3")){
                OutputPicture.printPictureOf(13);
                buildPressConference();
                flag = false;
            }else if(str.equals("4")){
                buildMedalMakingProcedure();
                OutputPicture.printPictureOf(12);
                buildInterview();
                OutputPicture.printPictureOf(13);
                buildPressConference();
                flag = false;
            }else{
                flag = false;
            }
        }
    }

    private void buildInterview(){
        List<String> interviewInitPrintBlock = new ArrayList<>();
        interviewInitPrintBlock.add("赛后采访");
        interviewInitPrintBlock.add("下面是纸媒和新媒体记者对金牌得主的采访，您可以在采访后看到他们发布的报道。");
        PrintBlockFormat.getPrintFormat().printFormatMiddleScreen(interviewInitPrintBlock,true);

        List<Interviewer> ceremonyInterviewer = PersonFactory.getInstance().getInterviews();
        List<Interviewer> goldInterviewers = new ArrayList<Interviewer>();
        int interviewerIndex = new Random().nextInt(50);

        Interviewer goldInterviewerNewpaper = ceremonyInterviewer.get(interviewerIndex);
        goldInterviewerNewpaper.setStrategy(new AfterInterviewAthleteStrategy());
        goldInterviewerNewpaper.setReportBuilder(new NewspaperBuilder(goldInterviewerNewpaper.getName(),goldPlayer.getName()));

        Interviewer goldInterviewerInternet = ceremonyInterviewer.get(interviewerIndex+1);
        goldInterviewerInternet.setStrategy(new AfterInterviewAthleteStrategy());
        goldInterviewerInternet.setReportBuilder(new InternetReportBuilder(goldInterviewerInternet.getName(),goldPlayer.getName()));

        goldInterviewers.add(goldInterviewerInternet);
        goldInterviewers.add(goldInterviewerNewpaper);

        List<String> goldInterviewPrintBlock = new ArrayList<>();
        goldInterviewPrintBlock.add("金牌获奖者采访");
        goldInterviewPrintBlock.add("被采访人："+goldPlayer.getName() +" 采访人：纸媒记者"+ goldInterviewerNewpaper.getName()+ "，新媒体记者"+ goldInterviewerInternet.getName());

        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(goldInterviewPrintBlock,true);
        InterviewMaker.makeInterview(goldPlayer, goldInterviewers, PersonFactory.getInstance().getAthletes("Marathon"),3);

        Coach intervieweeCoach = PersonFactory.getInstance().getCoach();

        List<Interviewer> coachInterviewers = new ArrayList<Interviewer>();
        Interviewer coachInterviewerNewspaper = ceremonyInterviewer.get(interviewerIndex+2);
        coachInterviewerNewspaper.setStrategy(new AfterInterviewCoachStrategy());
        coachInterviewerNewspaper.setReportBuilder(new NewspaperBuilder(coachInterviewerNewspaper.getName(),intervieweeCoach.getName()));

        Interviewer coachInterviewerInternet = ceremonyInterviewer.get(interviewerIndex+3);
        coachInterviewerInternet.setStrategy(new AfterInterviewAthleteStrategy());
        coachInterviewerInternet.setReportBuilder(new InternetReportBuilder(coachInterviewerInternet.getName(),intervieweeCoach.getName()));

        coachInterviewers.add(coachInterviewerInternet);
        coachInterviewers.add(coachInterviewerNewspaper);

        List<String> coachInterviewPrintBlock = new ArrayList<>();
        coachInterviewPrintBlock.add("裁判员采访");
        coachInterviewPrintBlock.add("被采访者："+intervieweeCoach.getName() +" | 采访人：纸媒记者"+ coachInterviewerNewspaper.getName()+ "、新媒体记者"+ coachInterviewerInternet.getName());
        printBlockFormat.printFormatLeftScreen(coachInterviewPrintBlock,true);

        InterviewMaker.makeInterview(intervieweeCoach, coachInterviewers, PersonFactory.getInstance().getAthletes("Marathon"),10);
    }

    private void buildPressConference(){
        List<String> pcInitPrintBlock = new ArrayList<>();
        pcInitPrintBlock.add("新闻发布会");
        pcInitPrintBlock.add("下面是本场比赛的新闻发布会");
        PrintBlockFormat.getPrintFormat().printFormatMiddleScreen(pcInitPrintBlock,true);

        List<Interviewer> ceremonyInterviewer = PersonFactory.getInstance().getInterviews();
        List<Interviewer> pcInterviewers = new ArrayList<>();
        int interviewerIndex = new Random().nextInt(50);

        Interviewer pcInterviewer_1 = ceremonyInterviewer.get(interviewerIndex);
        pcInterviewer_1.setStrategy(new PressConferenceStrategy());
        pcInterviewers.add(pcInterviewer_1);

        Interviewer pcInterviewer_2 = ceremonyInterviewer.get(interviewerIndex+1);
        pcInterviewer_2.setStrategy(new PressConferenceStrategy());
        pcInterviewers.add(pcInterviewer_2);

        Interviewer pcInterviewer_3 = ceremonyInterviewer.get(interviewerIndex+2);
        pcInterviewer_3.setStrategy(new PressConferenceStrategy());
        pcInterviewers.add(pcInterviewer_3);

        Interviewer pcInterviewer_4 = ceremonyInterviewer.get(interviewerIndex+3);
        pcInterviewer_4.setStrategy(new PressConferenceStrategy());
        pcInterviewers.add(pcInterviewer_4);


        List<String> coachInterviewPrintBlock = new ArrayList<>();
        coachInterviewPrintBlock.add("新闻发布会");
        coachInterviewPrintBlock.add("被提问方："+goldPlayer.getName() );
        coachInterviewPrintBlock.add("提问人：");
        coachInterviewPrintBlock.add("1."+pcInterviewer_1.getName()+"，来自 "+NameFactory.getChineseNaitonName(pcInterviewer_1.getNation()));
        coachInterviewPrintBlock.add("2."+pcInterviewer_2.getName()+"，来自 "+NameFactory.getChineseNaitonName(pcInterviewer_2.getNation()));
        coachInterviewPrintBlock.add("3."+pcInterviewer_3.getName()+"，来自 "+NameFactory.getChineseNaitonName(pcInterviewer_3.getNation()));
        coachInterviewPrintBlock.add("4."+pcInterviewer_4.getName()+"，来自 "+NameFactory.getChineseNaitonName(pcInterviewer_4.getNation()));

        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(coachInterviewPrintBlock,true);
        PressConferenceMaker.makePressConference(goldPlayer,pcInterviewers,PersonFactory.getInstance().getAthletes("Pingpong"),10 );
    }


}

