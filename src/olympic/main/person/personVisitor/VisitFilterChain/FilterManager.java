package olympic.main.person.personVisitor.VisitFilterChain;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;
import olympic.main.person.personVisitor.FilterVisitor;
import olympic.main.person.personVisitor.NovelCoronavirusFilterVisitor;
import olympic.main.person.personVisitor.UrineFilterVisitor;

import java.util.ArrayList;

public class FilterManager {
	FilterChain filterChain = new FilterChain();
	
 	public FilterManager(){
 		filterChain.addFilter(new NovelCoronavirusFilterVisitor());
 		filterChain.addFilter(new UrineFilterVisitor());
	}
	
	public void addFilter(FilterVisitor filterVisitor){
		filterChain.addFilter(filterVisitor);
	}
	
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList, String gameName) {
		return filterChain.visit(individualAthleteList, gameName);
	}
	
	public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList, String gameName) {
		return filterChain.visit(teamAthleteList, gameName);
	}
}
