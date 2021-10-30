package olympic.main.person.volunteer;

import olympic.main.person.Person;
import olympic.main.person.volunteer.state.ExpertState;
import olympic.main.person.volunteer.state.GreenhandState;
import olympic.main.person.volunteer.state.State;

public class Volunteer extends Person {
	protected Volunteer(String name, String nation) {
		super(name, nation);
	}
	
	private State state= GreenhandState.getInstance();
	
	private double englishLevel =  Math.random() * 10;
	private double physicalPower  =  Math.random() * 10;
	private double haveTime =  Math.random() * 10;
	
	
	public void changeStateToExpert(){
		if (state instanceof GreenhandState) {
			System.out.print("，本次志愿活动为该志愿者的第一次志愿活动。本次活动结束后，" +
					"该志愿者的状态将从不熟练业务到熟练业务。");
			state = ExpertState.getInstance();
		}else{
			System.out.print("，本次志愿活动并非该志愿者的第一次志愿活动。本次活动结束后，" +
					"该志愿者的状态不改变。");
		}
		System.out.println();
	}
	
	public boolean allocateWork(){
		return state.allocateWork(this);
	}
	
	public State getState() {
		return state;
	}
	
	public double getEnglishLevel() {
		return englishLevel;
	}
	
	public double getPhysicalPower() {
		return physicalPower;
	}
	
	public double getHaveTime() {
		return haveTime;
	}
}
