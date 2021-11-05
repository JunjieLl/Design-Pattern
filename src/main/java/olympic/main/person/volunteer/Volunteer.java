package olympic.main.person.volunteer;

import olympic.main.person.Person;
import olympic.main.person.volunteer.state.ExpertState;
import olympic.main.person.volunteer.state.GreenhandState;
import olympic.main.person.volunteer.state.State;

/**
 * 志愿者人物类
 * 与状态模式有关
 */
public class Volunteer extends Person {
	/**
	 * 志愿者类的构造函数
	 *
	 * @param name   志愿者姓名
	 * @param nation 志愿者国籍
	 */
	protected Volunteer(String name, String nation) {
		super(name, nation);
	}
	
	/**
	 * 志愿者的状态，默认为新手状态
	 */
	private State state = GreenhandState.getInstance();
	
	/**
	 * 志愿者的英语水平
	 */
	private final double englishLevel = Math.random() * 10;
	
	/**
	 * 志愿者的体力水平
	 */
	private final double physicalPower = Math.random() * 10;
	
	/**
	 * 志愿者的是否有时间
	 */
	private double haveTime = Math.random() * 10;
	
	
	/**
	 * 如果志愿者为新手状态，调用此函数可以把志愿者的状态从新手状态改为熟手状态。
	 * 如果志愿者为熟手状态，调用此函数不改变运动员状态状态。
	 *
	 * @param isPrint 控制是否输出classname语句
	 * @return 志愿者状态转换的说明
	 */
	public String changeStateToExpert(boolean isPrint) {
		if(isPrint) {
			System.out.println("classname: (Volunteer) method: (changeStateToExpert) " + "action: (把志愿者的状态从没有经验转换为有经验，使用了State模式以及singleton模式) ");
		}
		String output = "";
		if (state instanceof GreenhandState) {
			output = "，本次志愿活动为该志愿者的第一次志愿活动。本次活动结束后，" + "该志愿者的状态将从不熟练业务到熟练业务。";
			state = ExpertState.getInstance();
		} else {
			output = "，本次志愿活动并非该志愿者的第一次志愿活动。本次活动结束后，\" + \"该志愿者的状态不改变。";
			setHaveTime();
		}
		return output;
	}
	
	/**
	 * 为该志愿者分配工作
	 *
	 * @param isPrint 控制是否输出classname语句
	 * @return 是否为该志愿者分配工作
	 */
	public boolean allocateWork(boolean isPrint) {
		if(isPrint){
			System.out.println("classname: (Volunteer) method: (allocateVolunteer) " +
					"action: (把为志愿者分配岗位) ");
		}
		return state.allocateWork(this, isPrint);
	}
	
	/**
	 * 获取运动员状态
	 *
	 * @return 运动员状态
	 */
	public State getState() {
		return state;
	}
	
	/**
	 * 获取英语水平
	 *
	 * @return 运动员英语水平
	 */
	public double getEnglishLevel() {
		return englishLevel;
	}
	
	/**
	 * 获取运动员体力水平
	 *
	 * @return 运动员体力水平
	 */
	public double getPhysicalPower() {
		return physicalPower;
	}
	
	/**
	 * 获取运动员是否有时间
	 *
	 * @return 运动员是否有时间
	 */
	public double getHaveTime() {
		return haveTime;
	}
	
	/**
	 * 设置志愿者拥有的时间
	 */
	public void setHaveTime() {
		this.haveTime = Math.random() * 10;
	}
}
