package olympic.main.person.personVisitor;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

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
     * @param space 转换结束的字符串共占用的空格数，如果该整数的的大小小于space，则在数字前用空格填充
     * @return 转换结束后的字符串
     */
    protected String intToString(int num, int space) {
        StringBuilder str = new StringBuilder(((Integer) num).toString());
        int count = (int) StrictMath.log10(num) + 1;
        for (int i = 0; i < space - count; i++) {
            str.insert(0, " ");
        }
        return str.toString();
    }
}
