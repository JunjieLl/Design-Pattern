package olympic.main.person.athleteList.UrineTestProcurator;

import olympic.main.person.Person;

public abstract class UrineTestProcurator extends Person {
	protected UrineTestProcurator(String name, String nation) {
		super(name, nation);
	}
	
	public abstract void check();
}
