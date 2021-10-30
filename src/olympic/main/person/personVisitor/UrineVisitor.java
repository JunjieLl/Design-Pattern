package olympic.main.person.personVisitor;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

public class UrineVisitor extends Visitor{
	@Override
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList) {
		System.out.println("--------------------------------------------------------");
		individualAthleteUrineTest(individualAthleteList.getAthletes());
		System.out.println("--------------------------------------------------------");
		return individualAthleteList.getAthletes();
	}
	
	public void individualAthleteUrineTest(ArrayList<IndividualAthlete> individualAthletes){
		int count = 0;
		for (IndividualAthlete athlete : individualAthletes) {
			count += 1;
			System.out.print("- 运动员"+athlete.getName() + "完成尿检。");
			athlete.setUrineTestProcurator();
			athlete.getUrineTestProcurator().check();
			try {
				athlete.addUrineBottle('A');
				System.out.print("- 	生成尿样A，");
				athlete.setUrineTestStrategy(0,3);
				
				athlete.addUrineBottle('B');
				System.out.print("- 	生成尿样B，");
				athlete.setUrineTestStrategy(0,4);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}
	
	@Override
	public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList) {
		System.out.println("--------------------------------------------------------");
		int count = 0;
		int size = teamAthleteList.getAthletes().size();
		for (TeamAthlete team : teamAthleteList.getAthletes()) {
			count += 1;
			System.out.println("正在接受尿检队伍来自" + team.getNation());
			ArrayList<IndividualAthlete> res = new ArrayList<>();
			for (Athlete athlete:team.getAthleteList()){
				res.add((IndividualAthlete) athlete);
			}
			individualAthleteUrineTest(res);
			if (count!=size) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		}
		System.out.println("--------------------------------------------------------");
		return teamAthleteList.getAthletes();
	}
}
