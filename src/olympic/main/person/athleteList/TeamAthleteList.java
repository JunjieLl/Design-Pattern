package olympic.main.person.athleteList;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.personVisitor.Visitor;

import java.util.ArrayList;

public class TeamAthleteList implements AthleteList {
	
	private ArrayList<TeamAthlete> athletes = null;
	
	public TeamAthleteList(ArrayList<TeamAthlete> athletes){
		this.athletes = athletes;
	}
	
	@Override
	public void accept(Visitor v) {
		
		v.visit(this);
	}
	
	public IndividualAthleteList getTeam(int num){
		return new IndividualAthleteList((ArrayList<IndividualAthlete>) athletes.get(num).getAthleteList());
	}
	
	public ArrayList<TeamAthlete> getAthletes() {
		return athletes;
	}
}
