package olympic.main.PreCompetitionSystem;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.AthleteList;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;
import olympic.main.person.personVisitor.ConfirmEntryListVisitor;
import olympic.main.person.personVisitor.UrineFilterVisitor;
import olympic.main.person.personVisitor.UrineVisitor;
import olympic.main.person.personVisitor.VisitFilterChain.FilterManager;
import olympic.main.person.volunteer.VolunteerList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PreCompetitionSystemFacade {
	private int teamNum = 0;
	
	private PreCompetitionSystemFacade(){
	
	}
	
	final static PreCompetitionSystemFacade singleton = new PreCompetitionSystemFacade();
	
	public static PreCompetitionSystemFacade getInstance(){
		return singleton;
	}
	
	public ArrayList<Athlete> preCompetitionSystemFacade(String gameName) {
		AthleteList athletes;
		if (isTeamNumber(gameName)) {
			athletes = new TeamAthleteList(getAllTeam(gameName));
			System.out.println("【接下来进行" + gameName + "比赛的赛前准备环节】");
			System.out.println("【该项目为组队项目】");

		} else {
			athletes = new IndividualAthleteList(getAllIndividualAthlete(gameName));
			System.out.println("【接下来进行" + gameName + "比赛的赛前准备环节】");
			System.out.println("【该项目为个人项目】");

		}
		printlnNRowSpace(1);
		
		System.out.println("【首先生成尿检的检察官】");
		pressEnterToContinue();
		printlnNRowEllipsis(3);
		System.out.println("【检察官生成完成】");
		printlnNRowSpace(2);
		
		System.out.println("【开始分配监察官】");
		pressEnterToContinue();
		printlnNRowEllipsis(3);
		System.out.println("【检察官分配完成】");
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
		FilterManager filterManager=new FilterManager();
		if(canFilter(gameName)) {
			if (isTeamNumber(gameName)) {
				athletes = new TeamAthleteList(filterManager.visit((TeamAthleteList) athletes, gameName));
				
			} else {
				
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
		VolunteerList volunteerList=VolunteerList.getInstance();
		volunteerList.allocateVolunteer(15 + (int) (Math.random() * 10));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		printlnNRowSpace(2);
		
		System.out.println("【赛前准备结束】");
		
		if (isTeamNumber(gameName)) {
			ArrayList<Athlete> res = new ArrayList<>(((TeamAthleteList) athletes).getAthletes());
			return res;
			
		} else {
			ArrayList<Athlete> res = new ArrayList<>(((IndividualAthleteList) athletes).getAthletes());
			return res;
		}
	}
	
	private boolean canFilter(String gameName){
		if("FootballTeam".equals(gameName)||
				"Pingpong".equals(gameName)||"PingpongTeam".equals(gameName))
		{
			return false;
		}
		return true;
	}
	
	private ArrayList<Athlete> teamAthleteConvertToAthlete(ArrayList<TeamAthlete> teamAthletes){
		ArrayList<Athlete> res = new ArrayList<>(teamAthletes);
		return res;
	}
	
	private void pressEnterToContinue(){
		System.out.print("按下回车继续:");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Boolean isTeamNumber(String game) {
		return "PingpongTeam".equals(game) || "FootballTeam".equals(game) || "DivingTeam".equals(game) || "Relays".equals(game);
	}
	
	private String intToString(int num, int space){
		StringBuilder str = new StringBuilder(((Integer) num).toString());
		int count = (int) StrictMath.log10(num) + 1;
		for (int i=0;i<space-count;i++){
			str.insert(0, " ");
		}
		return str.toString();
	}
	
	private void printlnNRowEllipsis(int num){
		for(int i=0;i<num;i++){
			System.out.println("...");
		}
	}
	
	private void printlnNRowSpace(int num){
		for(int i=0;i<num;i++){
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		PreCompetitionSystemFacade preCompetitionSystemFacade = new PreCompetitionSystemFacade();
		preCompetitionSystemFacade.preCompetitionSystemFacade("Hurdling");
	}
	
	ArrayList<IndividualAthlete> getAllIndividualAthlete(String gameName) {
		PersonFactory personFactory= PersonFactory.getInstance();
		ArrayList<Athlete> a = (ArrayList<Athlete>)personFactory.getAthletes(gameName);
		ArrayList<IndividualAthlete> res = new ArrayList<>();
		for (Athlete athlete:a){
			res.add((IndividualAthlete) athlete);
		}
		return res;
	}
	
	ArrayList<TeamAthlete> getAllTeam(String gameName) {
		PersonFactory personFactory= PersonFactory.getInstance();
		List<Athlete> a = personFactory.getAthletes(gameName);
		ArrayList<TeamAthlete> res = new ArrayList<>();
		for (Athlete athlete:a){
			res.add((TeamAthlete) athlete);
		}
		return res;
	}
}
