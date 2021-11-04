package olympic.main.person.personVisitor;

import olympic.main.person.Person;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

/**
 * 确认参赛名单的访问者类
 * 涉及了访问者模式
 */
public class ConfirmEntryListVisitor extends Visitor {
    /**
     * 个人运动员列表类的访问函数，用于确认参加比赛的个人运动员
     *
     * @param individualAthleteList 个人运动员列表类
     * @return 参加比赛的运动员组成的个人运动员数组
     */
    @Override
    public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList) {
        System.out.println("classname: (ConfirmEntryListVisitor) method: (visit) " +
                "action: (确认个人运动员项目的参赛名单，使用了Visitor模式) ");
        stringList.add(" 共有" + individualAthleteList.getAthletes().size() + "位运动员参加该比赛");
        int count = 0;
        for (Person athlete : individualAthleteList.getAthletes()) {
            count += 1;
            stringList.add(" 第" + intToString(count, 3) + "位运动员的名字是" + athlete.getName() + "，来自" + athlete.getNation());
        }
        return individualAthleteList.getAthletes();
    }
    
    /**
     * 运动员队伍列表类的访问函数，用于确认参加比赛的运动员队伍
     *
     * @param teamAthleteList 运动员队伍列表类
     * @return 参加比赛的运动员队伍组成的运动员队伍数组
     */
    @Override
    public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList) {
        System.out.println("classname: (ConfirmEntryListVisitor) method: (visit) " +
                "action: (确认团队比赛的参赛名单，使用了Visitor模式) ");
        stringList.add(" 共有" + teamAthleteList.getAthletes().size() + "个队伍参加该比赛");
        int countTeam = 0;
        for (TeamAthlete team : teamAthleteList.getAthletes()) {
            countTeam += 1;
            int count = 0;
            stringList.add(" 第" + countTeam + "出场的队伍是" + team.getName() + "，来自" + team.getNation());
            for (Person athlete : team.getAthleteList()) {
                count += 1;
                stringList.add("     该队第" + intToString(count, 3) + "位运动员的名字是" + athlete.getName());
            }
            stringList.add("");
        }
        return teamAthleteList.getAthletes();
    }
}
