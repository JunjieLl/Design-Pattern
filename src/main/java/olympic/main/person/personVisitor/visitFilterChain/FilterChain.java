package olympic.main.person.personvisitor.visitfilterchain;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;
import olympic.main.person.personvisitor.FilterVisitor;


import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器链，保存着多个过滤器，根据特定顺序执行（这里是顺序执行）每个过滤器
 * 是过滤器模式的一部分
 */
public class FilterChain extends FilterVisitor {
	
	/**
	 * 给出所需要的输出列表
	 *
	 * @param num 第num个输出列表对应着第num个过滤链
	 * @return 第num个filter对应的输出列表
	 */
	public List<String> getShowList(int num){
		return filters.get(num).getStringList();
	}
	
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
	 * 个人运动员列表类的访问函数，用于按顺序对个人运动员列表做多次过滤
	 *
	 * @param individualAthleteList 个人运动员列表类
	 * @param gameName              比赛名
	 * @return 过滤结束以后的个人运动员数组
	 */
	@Override
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList, String gameName) {
		System.out.println("classname: (FilterChain) method: (visit) " +
				"action: (让尿检不合格以及感染新冠病毒的运动员退赛，使用了过滤器模式) ");
		ArrayList<IndividualAthlete> res = null;
		for (FilterVisitor filterVisitor : filters) {

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
		System.out.println("classname: (FilterChain) method: (visit) " +
				"action: (让尿检不合格以及感染新冠病毒的运动员退赛，使用了Filter模式) ");
		ArrayList<TeamAthlete> res = null;
		for (FilterVisitor filterVisitor : filters) {

			res = filterVisitor.visit(teamAthleteList, gameName);
			teamAthleteList.setAthletes(res);
			System.out.println();
		}
		return res;
	}
	
}
