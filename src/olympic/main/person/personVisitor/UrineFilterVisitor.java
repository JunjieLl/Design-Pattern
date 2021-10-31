package olympic.main.person.personVisitor;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

public class UrineFilterVisitor extends FilterVisitor {
	@Override
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList, String game) {
		ArrayList<IndividualAthlete> finalAthleteList = new ArrayList<>();
		System.out.println("	**********************************************************");
		int count = 0;
		for (IndividualAthlete athlete : individualAthleteList.getAthletes()) {
			if (athlete.getUrineTestResult(0)) {
				finalAthleteList.add(athlete);
			} else {
				System.out.println("	* 运动员" + athlete.getName() + "被检测出使用兴奋剂，参赛资格作废。");
				count += 1;
				athlete.setRank(game, -1);
			}
		}
		if (count == 0) {
			System.out.println("	* 没有运动员被检测出使用兴奋剂");
		} else {
			System.out.println("	^ 共有" + count + "位运动员使用了兴奋剂兴奋剂，被取消了比赛资格");
		}
		System.out.println("	**********************************************************");
		return finalAthleteList;
	}
	
	@Override
	public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList, String game) {
		ArrayList<TeamAthlete> finalTeam = new ArrayList<>();
		int count = 0;
		System.out.println("	**********************************************************");
		for (TeamAthlete team : teamAthleteList.getAthletes()) {
			System.out.println("	* 现在接受检查的队伍来自" + team.getNation()+"，队伍名为"+team.getName());
			boolean flag = true;
			for (Athlete athlete : team.getAthleteList()) {
				
				if (!((IndividualAthlete) athlete).getUrineTestResult(0)) {
					flag = false;
					athlete.setRank(game, -1);
				}
			}
			if (flag) {
				finalTeam.add(team);
				System.out.println("	* 所有队员均通过初步尿检");
			} else {
				count += 1;
				System.out.println("	* 队伍中有人使用兴奋剂，该队伍参赛资格作废");
			}
			System.out.println();
		}
		if (count == 0) {
			System.out.println("	^ 所有队伍均未使用兴奋剂");
		} else {
			System.out.println("	^ 共有" + count + "个队伍使用了兴奋剂，被取消了比赛资格毒");
		}
		System.out.println("	**********************************************************");
		return finalTeam;
	}
	
	@Override
	public String getFilterName() {
		return "	【2. 现在进行尿样A瓶的检测】";
	}
}
