package olympic.main.person.volunteer.state;

import olympic.main.person.volunteer.Volunteer;

/**
 * 用于描述还没有工作经验的志愿者的状态
 * 涉及到状态模式，单例模式
 */
public class GreenhandState implements State{
	/**
	 * 无工作经验的志愿者状态的单例
	 */
	private static final GreenhandState singleton = new GreenhandState();
	
	/**
	 * 志愿者状态的构造函数，使用到了单例模式，是一个私有的构造函数
	 */
	private GreenhandState(){
	
	}
	
	/**
	 * 获取该类的状态（单例）
	 * @return 这个类的状态
	 */
	public static State getInstance(){
		return singleton;
	}
	
	/**
	 * 为无工作经验的志愿者分配工作的函数，主要考虑该志愿者的体力以及英语能力等指标
	 * @param volunteer 志愿者类
	 * @return 是否为该志愿者分配工作
	 */
	@Override
	public boolean allocateWork(Volunteer volunteer) {
		return volunteer.getPhysicalPower() > 2 && volunteer.getEnglishLevel() > 3;
	}
}
