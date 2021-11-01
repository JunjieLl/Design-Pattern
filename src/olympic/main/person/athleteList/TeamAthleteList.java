package olympic.main.person.athleteList;

import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.personVisitor.Visitor;

import java.util.ArrayList;

/**
 * 运动员队伍列表类，用于存储运动员队伍列表，并提供部分常用操作
 */
public class TeamAthleteList implements AthleteList {
	/**
	 * 运动员队伍列表
	 */
	private ArrayList<TeamAthlete> athletes;
	
	/**
	 * 设置该类的运动员队伍数组
	 *
	 * @param athletes 用于初始话队伍数组的数据
	 */
	public TeamAthleteList(ArrayList<TeamAthlete> athletes) {
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
	 * 获取该类保存的运动员队伍数组
	 *
	 * @return 该类保存的运动员队伍
	 */
	public ArrayList<TeamAthlete> getAthletes() {
		return athletes;
	}
	
	/**
	 * 设置该类的队伍数组
	 *
	 * @param athletes 用于设置运动员队伍数组的数据
	 */
	public void setAthletes(ArrayList<TeamAthlete> athletes) {
		this.athletes = athletes;
	}
}
