package olympic.PreCompetitionSystem;

import olympic.PreCompetitionSystem.UrineTest.UrineBottle;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.AthleteList;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;
import olympic.main.person.personVisitor.ConfirmEntryListVisitor;
import olympic.main.person.personVisitor.UrineFilterVisitor;
import olympic.main.person.personVisitor.UrineVisitor;
import olympic.main.person.volunteer.VolunteerList;
import olympic.main.person.volunteer.state.ExpertState;
import olympic.main.person.volunteer.state.GreenhandState;
import olympic.main.person.volunteer.state.State;


import java.io.IOException;
import java.util.ArrayList;

public class PreCompetitionSystemFacade {
	private int teamNum = 0;
	
	public ArrayList<Athlete> preCompetitionSystemFacade(String gameName) {
		
		System.out.println("接下来进行" + gameName + "比赛的赛前准备环节");
		AthleteList athletes;
		if (isTeamNumber(gameName)) {
			System.out.println("该项目为组队项目");
			athletes = new TeamAthleteList(getAllTeam(gameName));

		} else {
			athletes = new IndividualAthleteList(getAllIndividualAthlete(gameName));
			System.out.println("该项目为个人项目");

		}
		printlnNRowSpace(1);
		
		System.out.println("【首先生成尿检的检察官】");
		pressEnterToContinue();
		printlnNRowEllipsis(3);
		System.out.println("【检察官生成完成】");
		printlnNRowSpace(2);
		
		System.out.println("【开始分配检察官】");
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
		
		System.out.println("【接下来根据初步尿检结果评价参赛资格】");
		pressEnterToContinue();
		UrineFilterVisitor urineFilterVisitor = new UrineFilterVisitor();
		if (isTeamNumber(gameName)) {
			athletes = new TeamAthleteList(urineFilterVisitor.visit(
					(TeamAthleteList) athletes));
			
		} else {

			athletes = new IndividualAthleteList(urineFilterVisitor.visit(
					(IndividualAthleteList) athletes));
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
		volunteerList.allocateVolunteer(25 + (int) (Math.random() * 10));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		printlnNRowSpace(2);
		
		if (isTeamNumber(gameName)) {
			ArrayList<Athlete> res = new ArrayList<>(((TeamAthleteList) athletes).getAthletes());
			return res;
			
		} else {
			ArrayList<Athlete> res = new ArrayList<>(((IndividualAthleteList) athletes).getAthletes());
			return res;
		}
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
		switch (game) {
			case "乒乓":
				this.teamNum = 2;
				return true;
			case "足球":
				this.teamNum = 11;
				return true;
			case "跳水":
				return false;
			default:
				return false;
		}
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
		preCompetitionSystemFacade.preCompetitionSystemFacade("乒乓1");
	}
	
	ArrayList<IndividualAthlete> getAllIndividualAthlete(String gameName) {
		ArrayList<IndividualAthlete> a = new ArrayList<>();
		a.add(new IndividualAthlete("zch", "中国"));
		a.add(new IndividualAthlete("ljj", "中国"));
		a.add(new IndividualAthlete("llx", "中国"));
		a.add(new IndividualAthlete("zzy", "中国"));
		a.add(new IndividualAthlete("zby", "中国"));
		a.add(new IndividualAthlete("xmx", "中国"));
		return a;
	}
	
	ArrayList<TeamAthlete> getAllTeam(String gameName) {
		ArrayList<TeamAthlete> a = new ArrayList<>();
		TeamAthlete b = new TeamAthlete("中国");
		b.addChild(new IndividualAthlete("zch", "中国"));
		b.addChild(new IndividualAthlete("ljj", "中国"));
		b.addChild(new IndividualAthlete("llx", "中国"));
		b.addChild(new IndividualAthlete("zzy", "中国"));
		b.addChild(new IndividualAthlete("zby", "中国"));
		b.addChild(new IndividualAthlete("xmx", "中国"));
		a.add(b);
		TeamAthlete c = new TeamAthlete("美国");
		c.addChild(new IndividualAthlete("rcw", "中国"));
		c.addChild(new IndividualAthlete("zby", "中国"));
		c.addChild(new IndividualAthlete("xmx", "中国"));
		a.add(c);
		return a;
	}
}