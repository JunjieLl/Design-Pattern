package olympic.main.person.personvisitor;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

/**
 * 新冠病毒过滤器，用于过滤感染新冠病毒的队伍或者运动员
 * 涉及了过滤器模式以及访问者模式
 */
public class NovelCoronavirusFilterVisitor extends FilterVisitor {
    /**
     * 用于选择出选择出没有感染新冠病毒的运动员
     *
     * @param individualAthleteList 个人运动员列表类
     * @param game                  当场比赛的比赛名
     * @return 没有感染新冠病毒的个人运动员数组
     */
    @Override
    public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList, String game) {
        System.out.println("classname: (NovelCoronavirusFilterVisitor) method: (visit) " +
                "action: (过滤感染新冠病毒的运动员个人，使用了Visitor模式以及Filter模式) ");
        ArrayList<IndividualAthlete> finalAthleteList = new ArrayList<>();
        stringList.add("新冠病毒检测");
        int count = 0;
        for (IndividualAthlete athlete : individualAthleteList.getAthletes()) {
            if (!athlete.getIsNovelCoronavirus()) {
                finalAthleteList.add(athlete);
            }
            else {
                stringList.add(" 运动员\" + athlete.getName() + \"被检测出了新冠病毒，取消此次比赛资格。");
                count += 1;
                athlete.setRank(game, -1);
            }
        }
        if (count == 0) {
            stringList.add(" 所有运动员均未感染新冠病毒");
        } else {
            stringList.add(" 共有" + count + "位运动员感染了新冠病毒，被取消了比赛资格");
        }
        return finalAthleteList;
    }
    
    /**
     * 用于选择出没有感染新冠病毒的运动员队伍数组
     *
     * @param teamAthleteList 运动员队伍列表类
     * @param game            当场比赛的比赛名
     * @return 没有感染新冠病毒的运动员队伍数组
     */
    @Override
    public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList, String game) {
        System.out.println("classname: (NovelCoronavirusFilterVisitor) method: (visit) " +
                "action: (过滤感染新冠病毒的运动员队伍，使用了Visitor模式以及Filter模式) ");
        ArrayList<TeamAthlete> finalTeam = new ArrayList<>();
        stringList.add("新冠病毒检测");
        int count = 0;
        for (TeamAthlete team : teamAthleteList.getAthletes()) {
            stringList.add(" 现在接受检查的队伍来自" + team.getNation() + "，队伍名为" + team.getName());
            boolean flag = true;
            for (Athlete athlete : team.getAthleteList()) {
                
                if (((IndividualAthlete) athlete).getIsNovelCoronavirus()) {
                    flag = false;
                    athlete.setRank(game, -1);
                }
            }
            if (flag) {
                finalTeam.add(team);
                stringList.add(" 所有队员均未感染新冠病毒");
            }
            else {
                stringList.add(" 队伍中有人感染新冠病毒，该队伍参赛资格作废");
                count += 1;
            }
            stringList.add("");
        }
        if (count == 0) {
            stringList.add(" 所有队伍均未感染新冠病毒");
        }
        else {
            stringList.add(" 共有" + count + "个队伍感染了新冠病毒，被取消了比赛资格");
        }
        return finalTeam;
    }
    

}