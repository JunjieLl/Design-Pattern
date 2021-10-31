package olympic.main.person.personVisitor;

import olympic.main.person.Person;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

public class ConfirmEntryListVisitor extends Visitor {
	@Override
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("共有"+individualAthleteList.getAthletes().size()+"位运动员参加该比赛");
		int count = 0;
		for (Person athlete : individualAthleteList.getAthletes()) {
			count += 1;
			System.out.println("+ 第" + intToString(count,3) + "位运动员的名字是" + athlete.getName() + "，来自" + athlete.getNation());
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		return individualAthleteList.getAthletes();
	}
	
	@Override
	public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("共有"+teamAthleteList.getAthletes().size()+"个队伍参加该比赛");
		int countTeam = 0;
		for (TeamAthlete team : teamAthleteList.getAthletes()) {
			countTeam += 1;
			int count = 0;
			System.out.println("+ 第"+countTeam+"出场的队伍是" + team.getName()+ "，来自"+team.getNation());
			for (Person athlete : team.getAthleteList()) {
				count += 1;
				System.out.println("+     该队第" + intToString(count,3) + "位运动员的名字是" + athlete.getName());
			}
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		return teamAthleteList.getAthletes();
	}
}
