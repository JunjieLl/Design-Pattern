package olympic.main.person.personVisitor.VisitFilterChain;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;
import olympic.main.person.personVisitor.FilterVisitor;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 过滤器链，保存着多个过滤器，根据特定顺序执行（这里是顺序执行）每个过滤器
 * 是过滤器模式的一部分
 */
public class FilterChain extends FilterVisitor {
	/**
	 * 过滤器链，存储了多个过滤器
	 */
	private final ArrayList<FilterVisitor> filters = new ArrayList<>();
	
	/**
	 * 添加过滤器
	 *
	 * @param filterVisitor 需要添加的过滤器
	 */
	public void addFilter(FilterVisitor filterVisitor) {
		filters.add(filterVisitor);
	}
	
	/**
	 * 获取过滤器的名字
	 *
	 * @return 因为这个类为过滤器链，没有特定的名字，故返回null
	 */
	@Override
	public String getFilterName() {
		return null;
	}
	
	/**
	 * 个人运动员列表类的访问函数，用于按顺序对个人运动员列表做多次过滤
	 *
	 * @param individualAthleteList 个人运动员列表类
	 * @param gameName              比赛名
	 * @return 过滤结束以后的个人运动员数组
	 */
	@Override
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList, String gameName) {
		ArrayList<IndividualAthlete> res = null;
		for (FilterVisitor filterVisitor : filters) {
			System.out.println(filterVisitor.getFilterName());
			pressEnterToContinue();
			res = filterVisitor.visit(individualAthleteList, gameName);
			individualAthleteList.setAthletes(res);
			System.out.println();
		}
		return res;
	}
	
	/**
	 * 运动员队伍列表类的访问函数，用于按顺序对运动员队伍做多次过滤
	 *
	 * @param teamAthleteList 运动员队伍列表类
	 * @param gameName        比赛名
	 * @return 过滤结束以后的运动员队伍数组
	 */
	@Override
	public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList, String gameName) {
		ArrayList<TeamAthlete> res = null;
		for (FilterVisitor filterVisitor : filters) {
			System.out.println(filterVisitor.getFilterName());
			pressEnterToContinue();
			res = filterVisitor.visit(teamAthleteList, gameName);
			teamAthleteList.setAthletes(res);
			System.out.println();
		}
		return res;
	}
	
	/**
	 * 用于实现停顿功能，需要用户在按下回车后再继续执行程序
	 */
	private void pressEnterToContinue() {
		System.out.print("	按下回车继续:");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
