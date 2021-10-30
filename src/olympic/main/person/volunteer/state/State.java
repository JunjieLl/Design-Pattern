package olympic.main.person.volunteer.state;

import olympic.main.person.volunteer.Volunteer;

public interface State {
	
	public abstract boolean allocateWork(Volunteer volunteer);
}
