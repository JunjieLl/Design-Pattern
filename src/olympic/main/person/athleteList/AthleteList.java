package olympic.main.person.athleteList;

import olympic.main.person.Person;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.personVisitor.Visitor;

import java.util.ArrayList;

public interface AthleteList {

	public void accept(Visitor v);
	
}
