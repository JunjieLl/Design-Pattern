package olympic.main.person.personvisitor;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athletelist.IndividualAthleteList;
import olympic.main.person.athletelist.TeamAthleteList;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者的父类
 * 涉及了访问者模式
 */
public abstract class Visitor {
    /**
     * 个人运动员列表类的访问函数，对个人运动员列表类做操作
     *
     * @param individualAthleteList 个人运动员列表类
     * @return 个人运动员数组
     */
    public abstract ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList);
    
    /**
     * 运动员队伍列表类的访问函数，用于对运动员队伍类做操作
     *
     * @param teamAthleteList 运动员队伍列表类
     * @return 运动员队伍数组
     */
    public abstract ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList);
    
    /**
     * 把整数转换为字符串的函数，用语规范输出。
     *
     * @param num   被转换的整数
     * @return 转换结束后的字符串
     */
    protected String intToString(int num) {
        StringBuilder str = new StringBuilder(((Integer) num).toString());
        int count = (int) StrictMath.log10(num) + 1;
        for (int i = 0; i < 3 - count; i++) {
            str.insert(0, " ");
        }
        return str.toString();
    }
    
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
