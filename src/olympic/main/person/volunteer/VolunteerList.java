package olympic.main.person.volunteer;

import java.util.ArrayList;

/**
 * 志愿者列表类，存储了志愿者列表，可以支持一些对运动员列表的操作
 * 使用了单例模式
 */
public class VolunteerList {
	/**
	 * 志愿者列表
	 */
	ArrayList<Volunteer> volunteers = new ArrayList<>();
	
	/**
	 * 为志愿者列表分配工作时，当前志愿者的下标
	 */
	int count = 0;
	
	/**
	 * 运动员的总个数
	 */
	int allCount = 100;
	
	/**
	 * 志愿者列表的单例，保证所有比赛共用一个志愿者列表
	 */
	private static final VolunteerList singleton = new VolunteerList();
	
	/**
	 * 志愿者列表的构造函数，用于初始话志愿者列表
	 */
	private VolunteerList() {
		for (int i = 0; i < allCount; i++) {
			volunteers.add(new Volunteer("志愿者" + i, ""));
		}
	}
	
	/**
	 * 获取志愿者列表类
	 * @return 志愿者列表类
	 */
	public static VolunteerList getInstance() {
		return singleton;
	}
	
	/**
	 * 给定一个志愿者列表以及需要的志愿者人数，选择具体的志愿者
	 * @param num 预期需要的志愿者人数
	 * @return 被选中参加志愿活动的志愿者
	 */
	public ArrayList<Volunteer> allocateVolunteer(int num) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("> 协助该场比赛的志愿者预期有" + num + "人，他们分别为：");
		ArrayList<Volunteer> volunteersSelect = new ArrayList<>();
		int tempNum = num;
		int tempAll = allCount;
		for (; count < allCount; ) {
			count = (count + 1) % allCount;
			tempAll -= 1;
			if (volunteers.get(count).allocateWork()) {
				volunteersSelect.add(volunteers.get(count));
				num -= 1;
			}
			if (tempAll <= 0 || num <= 0) {
				break;
			}
		}
		for (int i = 0; i < volunteersSelect.size(); i++) {
			System.out.print("> " + volunteersSelect.get(i).getName());
			volunteersSelect.get(i).changeStateToExpert();
		}
		int gap = tempNum - volunteersSelect.size();
		System.out.println("> 协助该场比赛的志愿者人数实际为" + volunteersSelect.size() +
				"人。与预期相差" + gap + "人");
		return volunteersSelect;
	}
}
