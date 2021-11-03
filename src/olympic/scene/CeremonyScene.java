package olympic.scene;

import olympic.Utils.PrintBlockFormat;
import olympic.main.person.athlete.Athlete;
import olympic.main.postgame.award_ceremony.*;
import olympic.main.postgame.award_ceremony.prototype_framework.Manager;
import olympic.main.postgame.medaltable.MedalTable;
import olympic.scene.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 颁奖仪式的场景.
 * todo: 该场景是添加到比赛中的子场景，后续合并时将提供一个由参数构造函数，参数为获奖者.
 */
public class CeremonyScene implements Scene {
    private String goldPlayer;
    private String silverPlayer;
    private String bronzePlayer;

    public CeremonyScene(String gold, String silver, String bronze){
        this.goldPlayer = gold;
        this.silverPlayer = silver;
        this.bronzePlayer = bronze;
    }

    public CeremonyScene(List<Athlete> athletes){
        this.goldPlayer = athletes.get(0).getName() + ", TEAM " + athletes.get(0).getNation();
        this.silverPlayer = athletes.get(1).getName() + ", TEAM " + athletes.get(1).getNation();
        this.bronzePlayer = athletes.get(2).getName() + ", TEAM " + athletes.get(2).getNation();
        MedalTable.getInstance().addGold(athletes.get(0).getNation());
        MedalTable.getInstance().addSilver(athletes.get(1).getNation());
        MedalTable.getInstance().addBronze(athletes.get(2).getNation());
    }

    @Override
    public void play() {

        System.out.println("\nclassname: (CeremonyScene) method: (play) action: (颁奖仪式场景开始) ");
        List<String> ceremonyInitPrintBlock = new ArrayList<String>();
        ceremonyInitPrintBlock.add("颁奖仪式");
        ceremonyInitPrintBlock.add("女士们先生们，很荣幸为您呈现本场比赛的颁奖典礼。");
        ceremonyInitPrintBlock.add("在颁奖典礼之前，我们将在奖牌工厂向您展示奥运奖牌的制作过程。");

        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatMiddleScreen(ceremonyInitPrintBlock,true);

        new MedalMaking();

        System.out.println("\nclassname: (CeremonyScene) method: (play) action: (展示奖牌场景) \n");

        List<String> ceremonyPresentPrintBlock = new ArrayList<String>();
        ceremonyPresentPrintBlock.add("颁发奖牌");
        ceremonyPresentPrintBlock.add("让我们由衷祝贺奥林匹克奖牌获得者。");
        printBlockFormat.printFormatMiddleScreen(ceremonyPresentPrintBlock,true);
        
        Manager manager = new Manager();
        new MedalPresenting(manager, goldPlayer, silverPlayer, bronzePlayer);

        List<String> ceremonyEndingPrintBlock = new ArrayList<String>();
        ceremonyEndingPrintBlock.add("升国旗，奏国歌");
        ceremonyEndingPrintBlock.add("请全体肃立，升");
        printBlockFormat.printFormatMiddleScreen(ceremonyEndingPrintBlock,true);

        System.out.println("请全体起立，升国旗，奏国歌");
        System.out.println("本场颁奖仪式已经结束，请有序离场，并带好您的随身物品。");
        MedalTable.getInstance().printMedalTable();
        System.out.println("\n");
    }

}

