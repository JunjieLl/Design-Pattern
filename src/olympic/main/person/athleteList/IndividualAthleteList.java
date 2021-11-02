package olympic.main.person.athleteList;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.personVisitor.Visitor;

import java.util.ArrayList;

/**
 * 个人运动员列表类，用于存储个人运动员列表，并提供部分常用操作
 */
public class IndividualAthleteList implements AthleteList {
	/**
	 * 个人运动员的数组
	 */
	private ArrayList<IndividualAthlete> athletes;
	
	/**
	 * 运动员列表类类的构造函数
	 *
	 * @param athletes 用于初始化个人运动员数组的数据
	 */
	public IndividualAthleteList(ArrayList<IndividualAthlete> athletes) {
		this.athletes = athletes;
	}
	
	/**
	 * 用于接收一个访问器的函数
	 *
	 * @param v 一个访问器，用于访问该类，对该类做操作
	 */
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	/**
	 * 获取该类保存的个人运动员的数组
	 *
	 * @return 该类保存的个人运动员数组
	 */
	public ArrayList<IndividualAthlete> getAthletes() {
		return athletes;
	}
	
	/**
	 * 设置该类的个人运动员数组
	 *
	 * @param athletes 用于设置个人运动员数组的数据
	 */
	public void setAthletes(ArrayList<IndividualAthlete> athletes) {
		this.athletes = athletes;
	}
}
