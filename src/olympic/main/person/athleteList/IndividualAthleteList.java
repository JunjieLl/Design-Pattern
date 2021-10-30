package olympic.main.person.athleteList;

import olympic.PreCompetitionSystem.UrineTest.UrineTestStrategyFactory;
import olympic.main.person.UrineTestProcurator.UrineTestProcurator;
import olympic.main.person.UrineTestProcurator.UrineTestProcuratorProxy;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.personVisitor.Visitor;

import java.util.ArrayList;

public class IndividualAthleteList implements AthleteList {
	private ArrayList<IndividualAthlete> athletes = null;
	
	public IndividualAthleteList(ArrayList<IndividualAthlete> athletes){
		this.athletes = athletes;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public ArrayList<IndividualAthlete> getAthletes(){
		return athletes;
	}
	
}
