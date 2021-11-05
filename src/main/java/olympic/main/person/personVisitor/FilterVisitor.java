package olympic.main.person.personVisitor;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器类的父类
 * 涉及了过滤器模式以及访问者模式
 */
public abstract class FilterVisitor {
    /**
     * 个人运动员列表类的访问函数，用于过滤个人运动员列表
     *
     * @param individualAthleteList 个人运动员列表类
     * @param gameName              比赛名
     * @return 过滤结束以后的个人运动员数组
     */
    public abstract ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList, String gameName);
    
    /**
     * 运动员队伍列表类的访问函数，用于过滤链运动员队伍列表
     *
     * @param teamAthleteList 运动员队伍列表类
     * @param gameName        比赛名
     * @return 过滤结束以后的运动员队伍数组
     */
    public abstract ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList, String gameName);
    

    /**
     * 用于存储输出的数据结构
     */
    List<String> stringList = new ArrayList<>();
    
    /**
     * 用于获取输出列表
     *
     * @return 输出列表
     */
    public List<String> getStringList() {
        return stringList;
    }
}
