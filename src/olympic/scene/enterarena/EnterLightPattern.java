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

        String[] country=new String[30];
        country= PersonFactory.getInstance().getNations().toArray(new String[0]);
        for(int i=0;i<5;i++)
        {
            System.out.println(country[i]);
            TeamAthlete tempList=new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[i]),country[i]);
            if(tempList.getNumber()>0)
            {
                enterManager.setTeams(tempList);
                torchBarer.addMember(tempList.getFirstAthlete());
            }
        };

//        TeamAthlete chinaList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("中国"), "中国");
//        TeamAthlete koreaList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("韩国"), "韩国");
//        TeamAthlete japanList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("日本"), "日本");
//        TeamAthlete thailandList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("泰国"), "泰国");
//        TeamAthlete malaysiaList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("马来西亚"), "马来西亚");
//        TeamAthlete singaporeList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("新加坡"), "新加坡");
//        TeamAthlete russiaList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("俄罗斯"), "俄罗斯");
//        TeamAthlete polandList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("波兰"), "波兰");
//        TeamAthlete germanyList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("德国"), "德国");
//        TeamAthlete switzerlandList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("瑞士"), "瑞士");
//        TeamAthlete englandList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("英国"), "英国");
//        TeamAthlete hollandList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("荷兰"), "荷兰");
//        TeamAthlete frenchList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("法国"), "法国");
//        TeamAthlete spainList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("西班牙"), "西班牙");
//        TeamAthlete americaList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("美国"), "美国");
//        TeamAthlete australiaList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("澳大利亚"), "澳大利亚");
//
//
//
//
//        if(chinaList.getNumber()>0) {
//            enterManager.setTeams(chinaList);
//            torchBarer.addMember(chinaList.getFirstAthlete());
//        }
//        if(koreaList.getNumber()>0) {
//            enterManager.setTeams(koreaList);
//            torchBarer.addMember(koreaList.getFirstAthlete());
//        }
//        if(japanList.getNumber()>0) {
//            enterManager.setTeams(japanList);
//            torchBarer.addMember(japanList.getFirstAthlete());
//        }
//        if(thailandList.getNumber()>0) {
//            enterManager.setTeams(thailandList);
//        }
//        if(malaysiaList.getNumber()>0) {
//            enterManager.setTeams(malaysiaList);
//        }
//        if(singaporeList.getNumber()>0) {
//            enterManager.setTeams(singaporeList);
//        }
//        if(russiaList.getNumber()>0) {
//            enterManager.setTeams(russiaList);
//        }
//        if(polandList.getNumber()>0) {
//            enterManager.setTeams(polandList);
//        }
//        if(germanyList.getNumber()>0) {
//            enterManager.setTeams(germanyList);
//        }
//        if(switzerlandList.getNumber()>0) {
//            enterManager.setTeams(switzerlandList);
//        }
//        if(englandList.getNumber()>0) {
//            enterManager.setTeams(englandList);
//        }
//        if(hollandList.getNumber()>0) {
//            enterManager.setTeams(hollandList);
//        }
//        if(frenchList.getNumber()>0) {
//            enterManager.setTeams(frenchList);
//        }
//        if(spainList.getNumber()>0) {
//            enterManager.setTeams(spainList);
//        }
//        if(americaList.getNumber()>0) {
//            enterManager.setTeams(americaList);
//        }
//        if(australiaList.getNumber()>0) {
//            enterManager.setTeams(australiaList);
//        }
        EnterIterator et = enterManager.iterator();
        while(et.hasNext()) {
            TeamAthlete myList=et.next();
            System.out.println("现在向我们走来的是"+myList.getNation()+"队，让我们欢迎他们！");
        }

        torchBarer.passFire();

    }
}




