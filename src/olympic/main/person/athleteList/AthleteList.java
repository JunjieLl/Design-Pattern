package olympic.main.person.athleteList;

import olympic.main.person.personVisitor.Visitor;

public interface AthleteList {

	public void accept(Visitor v);
	
}
