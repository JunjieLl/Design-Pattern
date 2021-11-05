package olympic.main.person.personvisitor;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

/**
 * 尿检访问类，对运动员做尿检
 * 涉及了访问者模式
 */
public class UrineVisitor extends Visitor {
    /**
     * 用于控制是否要输出classname语句
     */
    boolean flag = true;
    /**
     * 对个人运动员列表中的每个运动员做尿检
     *
     * @param individualAthleteList 个人运动员列表类
     * @return 做完尿检的运动员数组
     */
    @Override
    public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList) {
        System.out.println("classname: (UrineVisitor) method: (visit) " +
                "action: (对个人运动员进行尿检，使用了Visitor模式) ");
        stringList.add("个人运动员尿检结果");
        individualAthleteUrineTest(individualAthleteList.getAthletes());
        return individualAthleteList.getAthletes();
    }
    
    /**
     * 对个人运动员列表中的每个运动员做尿检。该函数提取了运动员列表访问类以及运动员队伍访问类的公共操作，
     * 主要用于精简、复用代码
     *
     * @param individualAthletes 个人运动员列表类
     */
    public void individualAthleteUrineTest(ArrayList<IndividualAthlete> individualAthletes) {
        for (IndividualAthlete athlete : individualAthletes) {
            athlete.setUrineTestProcurator(flag);
            stringList.add("\t运动员" + athlete.getName() + "完成尿检。" + athlete.getUrineTestProcurator().check(flag));
            try {
                athlete.addUrineBottle('A');
                stringList.add("\t\t生成尿样A，" + athlete.setUrineTestStrategy(0, 3, flag));
                
                athlete.addUrineBottle('B');
                stringList.add("\t\t生成尿样B，" + athlete.setUrineTestStrategy(0, 4, flag));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            flag = false;
            //System.out.println();
        }
    }
    
    /**
     * 对运动员队伍列表中的每个队伍的每个运动员做尿检
     *
     * @param teamAthleteList 运动员队伍列表类
     * @return 做完尿检的运动队伍数组
     */
    @Override
    public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList) {
        System.out.println("classname: (UrineVisitor) method: (visit) " +
                "action: (对运动员团队进行尿检，使用了Visitor模式) ");
        stringList.add("运动员队伍尿检结果");
        for (TeamAthlete team : teamAthleteList.getAthletes()) {
            stringList.add("正在接受尿检队伍来自" + team.getNation());
            ArrayList<IndividualAthlete> res = new ArrayList<>();
            for (Athlete athlete : team.getAthleteList()) {
                res.add((IndividualAthlete) athlete);
            }
            individualAthleteUrineTest(res);
            stringList.add("");
            
        }
        return teamAthleteList.getAthletes();
    }
}

