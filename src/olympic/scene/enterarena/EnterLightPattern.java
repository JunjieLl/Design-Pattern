package olympic.scene.enterarena;


import olympic.main.game.football.FootballGameManager;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

/***
 * 两支国家队：美国队、中国队；每支队伍两名队员
 * 一支护送奥运圣火队伍：传递者一、二、三
 */

public class EnterLightPattern {
    public static void main(String[] args) {
        PersonFactory personFactory=PersonFactory.getInstance();
        EnterManager enterManager = EnterManager.getInstance();

        EnterTeam chinaList = new EnterTeam(PersonFactory.getInstance().getAthleteByNation("中国"), "中国");
        EnterTeam mengguList = new EnterTeam(PersonFactory.getInstance().getAthleteByNation("蒙古"), "蒙古");

        enterManager.setTeams(chinaList);
        enterManager.setTeams(mengguList);

        EnterIterator et = enterManager.iterator();
        while(et.hasNext()) {
            EnterTeam myList=et.next();
            System.out.println("现在向我们走来的是"+myList.getNation()+"队，让我们欢迎他们！");
        }


    }
}




