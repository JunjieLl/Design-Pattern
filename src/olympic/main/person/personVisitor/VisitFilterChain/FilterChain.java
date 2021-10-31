package olympic.main.person.personVisitor.VisitFilterChain;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;
import olympic.main.person.personVisitor.FilterVisitor;

import java.io.IOException;
import java.util.ArrayList;

public class FilterChain extends FilterVisitor{
	private ArrayList<FilterVisitor> filters= new ArrayList<>();
	
	public void addFilter(FilterVisitor filterVisitor){
		filters.add(filterVisitor);
	}
	
	@Override
	public String getFilterName() {
		return null;
	}
	
	@Override
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList, String gameName) {
		ArrayList<IndividualAthlete> res = null;
		for(FilterVisitor filterVisitor: filters){
			System.out.println(filterVisitor.getFilterName());
			pressEnterToContinue();
			res = filterVisitor.visit(individualAthleteList, gameName);
			individualAthleteList.setAthletes(res);
			System.out.println();
		}
		return res;
	}
	
	@Override
	public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList, String gameName) {
		ArrayList<TeamAthlete> res = null;
		for(FilterVisitor filterVisitor: filters){
			System.out.println(filterVisitor.getFilterName());
			pressEnterToContinue();
			res = filterVisitor.visit(teamAthleteList, gameName);
			teamAthleteList.setAthletes(res);
			System.out.println();
		}
		return res;
	}
	
	private void pressEnterToContinue(){
		System.out.print("	按下回车继续:");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
