package olympic.main.person.volunteer.state;

import olympic.main.person.volunteer.Volunteer;

/**
 * 用于描述已经有工作经验的志愿者的状态
 * 涉及到状态模式，单例模式
 */
public class ExpertState implements State {
	/**
	 * 有工作经验的志愿者状态的单例
	 */
	private static final ExpertState singleton = new ExpertState();
	
	/**
	 * 志愿者状态的构造函数，使用到了单例模式，是一个私有的构造函数
	 */
	private ExpertState() {
	
	}
	
	/**
	 * 获取该类的状态（单例）
	 *
	 * @return 这个类的状态
	 */
	public static State getInstance() {
		return singleton;
	}
	
	/**
	 * 为有工作经验的志愿者分配工作的函数，主要考虑该志愿者是否有时间
	 *
	 * @param volunteer 志愿者类
	 * @param isPrint 控制是否输出classname语句
	 * @return 是否为该志愿者分配工作
	 */
	@Override
	public boolean allocateWork(Volunteer volunteer, boolean isPrint) {
		if(isPrint) {
			System.out.println("classname: (ExpertState) method: (allocateWork) " + "action: (对有经验的志愿者分配工作，使用了State模式以及singleton模式) ");
		}
		return volunteer.getHaveTime() > 2;
	}
}
