package olympic.main.person.personVisitor;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

/**
 * 尿检访问类，对运动员做尿检
 * 涉及了访问者模式
 */
public class UrineVisitor extends Visitor{
	/**
	 * 对个人运动员列表中的每个运动员做尿检
	 * @param individualAthleteList 个人运动员列表类
	 * @return 做完尿检的运动员数组
	 */
	@Override
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList) {
		System.out.println("--------------------------------------------------------");
		individualAthleteUrineTest(individualAthleteList.getAthletes());
		System.out.println("--------------------------------------------------------");
		return individualAthleteList.getAthletes();
	}
	
	/**
	 * 对个人运动员列表中的每个运动员做尿检。该函数提取了运动员列表访问类以及运动员队伍访问类的公共操作，
	 * 主要用于精简、复用代码
	 * @param individualAthletes 个人运动员列表类
	 */
	public void individualAthleteUrineTest(ArrayList<IndividualAthlete> individualAthletes){
		for (IndividualAthlete athlete : individualAthletes) {
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
	
	/**
	 * 对运动员队伍列表中的每个队伍的每个运动员做尿检
	 * @param teamAthleteList 运动员队伍列表类
	 * @return 做完尿检的运动队伍数组
	 */
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
