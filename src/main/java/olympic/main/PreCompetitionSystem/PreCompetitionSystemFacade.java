package olympic.main.PreCompetitionSystem;

import olympic.Utils.PrintBlockFormat;
import olympic.main.director.Mode;
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
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 赛前准备的视窗类，用于整合赛前准备的总流程
 * 使用了单例模式，视窗模式
 */
public class PreCompetitionSystemFacade {
    HashMap<Integer, List<String>> showMap = new HashMap<>();
    
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
        showMap.clear();
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
        
        System.out.println("【运动员尿检】");
        urineTest(athletes);
        
        System.out.println("【筛选健康且未使用兴奋剂的运动员】");
        filterAthletes(athletes, gameName);
        
        System.out.println("【确认参赛名单】");
        confirmEntryListVisitor(athletes);
        
        System.out.println("【志愿者分配】");
        volunteerAllocate();
        
        System.out.println("【赛前准备结束】");
        
        if(Mode.getNeedDetail()){
           showDetail();
        }
        else {
            printAll();
        }
        
        if (isTeamNumber(gameName)) {
            assert athletes instanceof TeamAthleteList;
            return new ArrayList<>(((TeamAthleteList) athletes).getAthletes());
            
        } else {
            assert athletes instanceof IndividualAthleteList;
            return new ArrayList<>(((IndividualAthleteList) athletes).getAthletes());
        }
    }
    
    /**
     * 尿检的流程
     *
     * @param athletes 参赛比赛的运动员列表类
     */
    private void urineTest(AthleteList athletes) {
        UrineVisitor urineVisitor = new UrineVisitor();
        athletes.accept(urineVisitor);
        showMap.put(3, urineVisitor.getStringList());
        printlnNRowSpace(2);
    }
    
    /**
     * 志愿者分配
     */
    private void volunteerAllocate(){
        VolunteerList volunteerList = VolunteerList.getInstance();
        volunteerList.allocateVolunteer(15 + (int) (Math.random() * 10));
        printlnNRowSpace(2);
        showMap.put(8, volunteerList.getStringList());
    }
    
    /**
     * 使用过滤器筛选运动员的过程，分别会根据新冠病毒以及是否使用兴奋剂进行筛选
     *
     * @param athletes 参赛比赛的运动员列表类
     * @param gameName 比赛名
     */
    private void filterAthletes(AthleteList athletes, String gameName) {
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
            showMap.put(5, filterManager.getShowList(0));
            showMap.put(6, filterManager.getShowList(1));
        } else {
            if (gameName.equals("Pingpong")||gameName.equals("Badminton")) {
                List<String> str = new ArrayList<>();
                str.add("新冠病毒检测");
                str.add(" 所有运动员均未感染新冠病毒");
                showMap.put(5, str);
                str.clear();
                str.add("尿检结果检测");
                str.add(" 没有运动员被检测出使用兴奋剂");
                showMap.put(6, str);
            } else {
                List<String> str = new ArrayList<>();
                str.add("新冠病毒检测");
                str.add(" 所有队伍均未感染新冠病毒");
                showMap.put(5, str);
                str.clear();
                str.add("尿检结果检测");
                str.add(" 所有队伍均未使用兴奋剂");
                showMap.put(6, str);
            }
        }
        
        printlnNRowSpace(2);
    }
    
    /**
     * 输出所有的赛前准备环节
     */
    private void printAll(){
        System.out.println("[赛前准备的详细输出如下:]");
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(showMap.get(3), true);
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(showMap.get(5), true);
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(showMap.get(6), true);
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(showMap.get(7), true);
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(showMap.get(8), true);
        System.out.println("[赛前准备展示环节结束]");
    }
    
    /**
     * 确认参赛名单
     *
     * @param athletes 参加赛前准备的运动员
     */
    private void confirmEntryListVisitor(AthleteList athletes){
        ConfirmEntryListVisitor confirmEntryListVisitor = new ConfirmEntryListVisitor();
        athletes.accept(confirmEntryListVisitor);
        showMap.put(7, confirmEntryListVisitor.getStringList());
        printlnNRowSpace(2);
    }
    
    /**
     * 打印赛前准备的流程
     */
    private void printProcedure() {
        List<String> strings = new ArrayList<>();
        strings.add("赛前准备总流程");
        strings.add("1. 生成尿检的检察员");
        strings.add("2. 分配尿检的检察员");
        strings.add("3. 运动员尿检环节（可查看）");
        strings.add("4. 运动员填写《兴奋剂检查记录单》和《兴奋剂检查传送单》");
        strings.add("5. 新冠病毒结果检验（可查看）");
        strings.add("6. 尿检结果检验（可查看）");
        strings.add("7. 确认参赛名单（可查看）");
        strings.add("8. 分配志愿者（可查看）");
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(strings, true);
    }
    
    /**
     * 输出的提示文字
     */
    private void printHelp() {
        List<String> strings = new ArrayList<>();
        strings.add("输入序号可查看具体信息");
        strings.add("1. 输入help可查看提示信息");
        strings.add("2. 输入3可查看运动员尿检环节");
        strings.add("3. 输入5可查看新冠病毒结果检验");
        strings.add("4. 输入6可查看尿检结果检验");
        strings.add("5. 输入7可查看参赛名单");
        strings.add("6. 输入8可查看分配志愿者状况");
        strings.add("7. 输入1-8的其他值会提示不可显示");
        strings.add("8. 输入其他值退出循环");
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(strings, true);
    }
    
    /**
     * 展示某些环节的细节
     */
    private void showDetail() {
        printHelp();
        Scanner scanner = new Scanner(System.in);
        String str;
        boolean flag = true;
        while (flag) {
            System.out.println("[请输入想详细查看的环节:]");
            str = scanner.nextLine();
            switch (str) {
                case "1":
                case "2":
                case "4":
                    System.out.println("[不提供本环节的详细展示]");
                    break;
                case "3":
                case "5":
                case "6":
                case "7":
                case "8":
                    PrintBlockFormat.getPrintFormat().printFormatLeftScreen(showMap.get(Integer.parseInt(str)), true);
                    break;
                case "help":
                    printHelp();
                    break;
                default:
                    flag = false;
                    System.out.println("[赛前准备展示环节结束]");
                    break;
            }
        }
    }
    
    
    /**
     * 判断是否能对一个比赛使用过滤器
     *
     * @param gameName 比赛名
     * @return 是否能对比赛gameName使用过滤器
     */
    private boolean canFilter(String gameName) {
        return !"FootballTeam".equals(gameName) && !"Pingpong".equals(gameName) && !"PingpongTeam".equals(gameName)
                && !"Badminton".equals(gameName)&& !"BadmintonTeam".equals(gameName) &&
                !"BasketballTeam".equals(gameName) && !"VolleyballTeam".equals(gameName);
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
        if(game.endsWith("Team")){
            return true;
        }
        return "Relays".equals(game);
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
        preCompetitionSystemFacade.preCompetitionSystemFacade("Badminton");
        preCompetitionSystemFacade.preCompetitionSystemFacade("BadmintonTeam");
        preCompetitionSystemFacade.printAll();
        
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
