package olympic.main.person.volunteer.state;

import olympic.main.person.volunteer.Volunteer;

/**
 * 状态类，用于描述志愿者的状态
 * 使用了状态模式
 */
public interface State {
	/**
	 * 用于为志愿者分配工作
	 * @param volunteer 志愿者类
	 * @return 是否为为该志愿者分配工作
	 */
	boolean allocateWork(Volunteer volunteer);
}
