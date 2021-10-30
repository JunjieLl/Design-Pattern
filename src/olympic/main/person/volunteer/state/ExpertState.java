package olympic.main.person.volunteer.state;

import olympic.main.person.volunteer.Volunteer;

public class ExpertState implements State {
	private static ExpertState singleton = new ExpertState();
	private ExpertState(){
	
	}
	
	public static State getInstance(){
		return singleton;
	}
	
	@Override
	public boolean allocateWork(Volunteer volunteer) {
		return volunteer.getHaveTime() > 3;
	}
}
