package olympic.main.person.personVisitor;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

public class UrineFilterVisitor extends Visitor {
	@Override
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList) {
		ArrayList<IndividualAthlete> finalAthleteList = new ArrayList<>();
		System.out.println("**********************************************************");
		int count = 0;
		for (IndividualAthlete athlete : individualAthleteList.getAthletes()) {
			if (athlete.getUrineTestResult(0)) {
				finalAthleteList.add(athlete);
			}
			else {
				System.out.println("* 运动员" + athlete.getName() + "被检测出使用兴奋剂，参赛资格作废。");
				count+=1;
			}
		}
		if(count==0)
		{
			System.out.println("* 没有运动员被检测出使用兴奋剂");
		}
		System.out.println("**********************************************************");
		return finalAthleteList;
	}
	
	@Override
	public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList) {
		ArrayList<TeamAthlete> finalTeam = new ArrayList<>();
		System.out.println("**********************************************************");
		for (TeamAthlete team : teamAthleteList.getAthletes()) {
			int count = 0;
			System.out.println("* 现在接受检查的队伍来自" + team.getNation());
			boolean flag = true;
			for (Athlete athlete : team.getAthleteList()) {
				
				if (!((IndividualAthlete)athlete).getUrineTestResult(0)) {
					flag = false;
				} else {
				}
			}
			if (flag) {
				finalTeam.add(team);
				System.out.println("* 所有队员均通过初步尿检");
			} else {
				System.out.println("* 队伍中有人使用兴奋剂，该队伍参赛资格作废");
			}
			System.out.println();
		}
		System.out.println("**********************************************************");
		return finalTeam;
	}
	
}
