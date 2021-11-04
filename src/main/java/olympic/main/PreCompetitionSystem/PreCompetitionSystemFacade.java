package main.java.olympic.main.PreCompetitionSystem;

import olympic.Utils.PrintBlockFormat;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.AthleteList;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;
import olympic.main.person.personVisitor.ConfirmEntryListVisitor;
import olympic.main.person.personVisitor.UrineVisitor;
import olympic.main.person.personVisitor.VisitFilterChain.FilterManager;
import olympic.main.person.volunteer.VolunteerList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 赛前准备的视窗类，用于整合赛前准备的总流程
 * 使用了单例模式，视窗模式
 */
public class PreCompetitionSystemFacade {
    /**
     * 视窗类的构造函数，是一个私有类，这是单例模式的一部分
     */
    private PreCompetitionSystemFacade() {

    }

    /**
     * 视赛前准备窗类的单例，保证所有被使用的赛前准备视窗类是一致的
     */
    final static PreCompetitionSystemFacade singleton = new PreCompetitionSystemFacade();

    /**
     * 获取赛前准备视窗的实例
     */
    public static PreCompetitionSystemFacade getInstance() {
        return singleton;
    }

    /**
     * 赛前准备的总流程，赛前准备流程为：生成尿检的检察员->分配监察员->运动员尿检
     * ->运动员填写《兴奋剂检查记录单》和《兴奋剂检查传送单》->检测运动员是否感染了新冠病毒
     * ->检测运动员是否感染了新冠病毒->确认参赛名单->分配志愿者
     * <p>
     * 我把赛前比赛繁杂的流程总结到了这个类中，方便其他队友的调用
     *
     * @param gameName 比赛名
     * @return 参赛比赛运动员的运动员列表
     */
    public ArrayList<Athlete> preCompetitionSystemFacade(String gameName) {
        System.out.println("classname: (PreCompetitionSystemFacade) method: (preCompetitionSystemFacade) " + "action: (赛前准备流程，使用了Facade模式以及singleton模式) ");
        AthleteList athletes;
        if (isTeamNumber(gameName)) {
            athletes = new TeamAthleteList(getAllTeam(gameName));
            System.out.println("[接下来进行" + gameName + "比赛的赛前准备环节]");
            System.out.println("[该项目为组队项目]");

        } else {
            athletes = new IndividualAthleteList(getAllIndividualAthlete(gameName));
            System.out.println("[接下来进行" + gameName + "比赛的赛前准备环节]");
            System.out.println("[该项目为个人项目]");

        }
        printProcedure();

        printlnNRowSpace(1);

        System.out.println("【首先生成尿检的检察员】");
        pressEnterToContinue();
        printlnNRowEllipsis(2);
        printlnNRowEllipsis(1);
        System.out.println("【检察员生成完成】");
        printlnNRowSpace(2);

        System.out.println("【开始分配监察员】");
        pressEnterToContinue();
        printlnNRowEllipsis(3);
        System.out.println("【检察员分配完成】");
        printlnNRowSpace(2);

        System.out.println("【接下来为运动员尿检环节】");
        pressEnterToContinue();
        athletes.accept(new UrineVisitor());
        System.out.println("【尿检结束】");
        printlnNRowSpace(2);

        System.out.println("【所有运动员填写《兴奋剂检查记录单》和《兴奋剂检查传送单》】");
        pressEnterToContinue();
        printlnNRowEllipsis(3);
        System.out.println("【运动员填写完成】");
        printlnNRowSpace(2);

        System.out.println("【接下来根据初步运动员身体状况（是否感染新冠病毒）以及尿检结果评价参赛资格】");
        FilterManager filterManager = new FilterManager();
        if (canFilter(gameName)) {
            if (isTeamNumber(gameName)) {
                assert athletes instanceof TeamAthleteList;
                athletes = new TeamAthleteList(filterManager.visit((TeamAthleteList) athletes, gameName));

            } else {

                assert athletes instanceof IndividualAthleteList;
                athletes = new IndividualAthleteList(filterManager.visit((IndividualAthleteList) athletes, gameName));
            }
        }
        System.out.println("【筛选结束，剩下的人有资格参加比赛】");
        printlnNRowSpace(2);

        System.out.println("【接下来进行确认参赛名单环节，参赛人员如下：】");
        pressEnterToContinue();
        athletes.accept(new ConfirmEntryListVisitor());
        printlnNRowSpace(2);

        System.out.println("【最后，为该场比赛分配志愿者以协助比赛顺利进行】");
        pressEnterToContinue();
        VolunteerList volunteerList = VolunteerList.getInstance();
        volunteerList.allocateVolunteer(15 + (int) (Math.random() * 10));
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        printlnNRowSpace(2);

        System.out.println("【赛前准备结束】");

        if (isTeamNumber(gameName)) {
            assert athletes instanceof TeamAthleteList;
            return new ArrayList<>(((TeamAthleteList) athletes).getAthletes());

        } else {
            assert athletes instanceof IndividualAthleteList;
            return new ArrayList<>(((IndividualAthleteList) athletes).getAthletes());
        }
    }

    /**
     * 打印赛前准备的流程以及查看详细输出的提示文字
     */
    private void printProcedure() {
        List<String> strings = new ArrayList<>();
        strings.add("赛前准备总流程");
        strings.add("1. 生成尿检的检察员");
        strings.add("2. 分配尿检的检察员");
        strings.add("3. 运动员尿检环节");
        strings.add("4. 运动员填写《兴奋剂检查记录单》和《兴奋剂检查传送单》");
        strings.add("5. 新冠病毒结果检验");
        strings.add("6. 尿检结果检验");
        strings.add("7. 确认参赛名单");
        strings.add("8. 分配志愿者");
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(strings, true);
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(strings, true);
        PrintBlockFormat.getPrintFormat().printFormatMiddleScreen(strings, true);
        PrintBlockFormat.getPrintFormat().printFormatMiddleScreen(strings, true);
    }

    /**
     * 判断是否能对一个比赛使用过滤器
     *
     * @param gameName 比赛名
     * @return 是否能对比赛gameName使用过滤器
     */
    private boolean canFilter(String gameName) {
        return !"FootballTeam".equals(gameName) && !"Pingpong".equals(gameName) && !"PingpongTeam".equals(gameName);
    }

    /**
     * 为运行中的程序提供一个停顿，当用户输入回车时继续程序
     */
    private void pressEnterToContinue() {
        System.out.print("按下回车继续:");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断输入的比赛是组队模式的比赛还是单人模式的比赛
     *
     * @param game 比赛名
     * @return 如果输入的比赛是组队模式，返回true，反之返回false
     */
    private Boolean isTeamNumber(String game) {
        return "PingpongTeam".equals(game) || "FootballTeam".equals(game) || "DivingTeam".equals(game) || "Relays".equals(game);
    }

    /**
     * 输出num行的...
     *
     * @param num 输出"..."的行数
     */
    private void printlnNRowEllipsis(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("...");
        }
    }

    /**
     * 输出num行的空格
     *
     * @param num 输出空格的行数
     */
    private void printlnNRowSpace(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println();
        }
    }

    /**
     * 赛前子系统的测试函数
     *
     * @param args 程序的输入参数
     */
    public static void main(String[] args) {
        PreCompetitionSystemFacade preCompetitionSystemFacade = new PreCompetitionSystemFacade();
        preCompetitionSystemFacade.preCompetitionSystemFacade("Diving");
        preCompetitionSystemFacade.preCompetitionSystemFacade("Relays");
        preCompetitionSystemFacade.preCompetitionSystemFacade("Sprints");
    }

    /**
     * 获取某一个个人比赛的所有运动员
     *
     * @param gameName 输入比赛名
     * @return 某一个人比赛的所有运动员（个人比赛）
     */
    ArrayList<IndividualAthlete> getAllIndividualAthlete(String gameName) {
        PersonFactory personFactory = PersonFactory.getInstance();
        ArrayList<Athlete> a = (ArrayList<Athlete>) personFactory.getAthletes(gameName);
        ArrayList<IndividualAthlete> res = new ArrayList<>();
        for (Athlete athlete : a) {
            res.add((IndividualAthlete) athlete);
        }
        return res;
    }

    /**
     * 获取一个比赛的所有队伍
     *
     * @param gameName 输入比赛名
     * @return 某比赛的所有队伍（团队比赛）
     */
    ArrayList<TeamAthlete> getAllTeam(String gameName) {
        PersonFactory personFactory = PersonFactory.getInstance();
        List<Athlete> a = personFactory.getAthletes(gameName);
        ArrayList<TeamAthlete> res = new ArrayList<>();
        for (Athlete athlete : a) {
            res.add((TeamAthlete) athlete);
        }
        return res;
    }
}
