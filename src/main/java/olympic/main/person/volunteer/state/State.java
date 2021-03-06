package olympic.main.person.volunteer.state;

import olympic.main.person.volunteer.Volunteer;

/**
 * 状态类，用于描述志愿者的状态
 * 使用了状态模式
 */
public interface State {
	/**
	 * 用于为志愿者分配工作
	 *
	 * @param volunteer 志愿者类
	 * @param isPrint 控制是否输出classname语句
	 * @return 是否为该志愿者分配工作
	 */
	boolean allocateWork(Volunteer volunteer, boolean isPrint);
}
