package olympic.scene.enterarena;


import olympic.main.game.football.FootballGameManager;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

import java.util.ArrayList;
import java.util.List;

/***
 * 两支国家队：美国队、中国队；每支队伍两名队员
 * 一支护送奥运圣火队伍：传递者一、二、三
 */

public class EnterLightPattern {
    public static void main(String[] args) {
        EnterManager enterManager = EnterManager.getInstance();
        TeamAthlete torchBarer=new TeamAthlete("火炬传递队");

        String[] country=new String[48];
        country= PersonFactory.getInstance().getNations().toArray(new String[0]);

        for(int i=0;i<48;i++)
        {
            if(i%3==0)
            {
                TeamAthlete tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[i]),country[i]);
                    if (tempList.getNumber() > 0) {
                        enterManager.setTeams(tempList);
                        if(i%6==0)
                        { torchBarer.addMember(tempList.getFirstAthlete());}
                   }
//            switch (country[i]){
//                case "CHN":
//                    TeamAthlete tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[i]),country[i]);
//                    if (tempList.getNumber() > 0) {
//                        enterManager.setTeams(tempList);
//                        torchBarer.addMember(tempList.getFirstAthlete());
//                    }
//                    break;
//                case "KOR":
//                    tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[i]),country[i]);
//                    if (tempList.getNumber() > 0) {
//                        enterManager.setTeams(tempList);
//                        torchBarer.addMember(tempList.getFirstAthlete());
//                    }
//                    break;
//                case "USA":
//                    tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[i]),country[i]);
//                    if (tempList.getNumber() > 0) {
//                        enterManager.setTeams(tempList);
//                        torchBarer.addMember(tempList.getFirstAthlete());
//                    }
//                    break;
//                case "JPN":
//                    tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[i]),country[i]);
//                    if (tempList.getNumber() > 0) {
//                        enterManager.setTeams(tempList);
//                        torchBarer.addMember(tempList.getFirstAthlete());
//                    }
//                    break;
//                case "FRA":
//                    tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[i]),country[i]);
//                    if (tempList.getNumber() > 0) {
//                        enterManager.setTeams(tempList);
//                        torchBarer.addMember(tempList.getFirstAthlete());
//                    }
//                    break;
//                case "GER":
//                    tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[i]),country[i]);
//                    if (tempList.getNumber() > 0) {
//                        enterManager.setTeams(tempList);
//                        torchBarer.addMember(tempList.getFirstAthlete());
//                    }
//                    break;

            }

        };

        EnterIterator et = enterManager.iterator();
        while(et.hasNext()) {
            TeamAthlete myList=et.next();
            System.out.println("现在向我们走来的是"+myList.getNation()+"队，让我们欢迎他们！");
        }
        System.out.println('\n');
        torchBarer.passFire();
        System.out.println("最后一位使者点燃了奥运圣火！");

    }
}
