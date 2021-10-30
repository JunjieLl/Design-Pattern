package olympic.main.person.volunteer.state;

import olympic.main.person.volunteer.Volunteer;

public class GreenhandState implements State{
	private static GreenhandState singleton = new GreenhandState();
	private GreenhandState(){
	
	}
	
	public static State getInstance(){
		return singleton;
	}
	
	@Override
	public boolean allocateWork(Volunteer volunteer) {
		return volunteer.getPhysicalPower() > 3 && volunteer.getEnglishLevel() > 5;
	}
}
