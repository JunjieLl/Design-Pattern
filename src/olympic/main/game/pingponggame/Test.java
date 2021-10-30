package olympic.main.game.pingponggame;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.pingong.PingpongAthlete;
import olympic.main.person.athlete.pingong.PingpongTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args){

        PersonFactory.getInstance().springUtil();

        PreCompetitionSystemFacade pre = new PreCompetitionSystemFacade();

        System.out.println("请选择是否展示细节，输入true展示细节，输入其他不展示");
        Scanner input=new Scanner(System.in);
        //接受String类型
        Mode.setShowDetail(input.next().equals("true"));

        List<Athlete> athletes = new ArrayList<>();

        List<Athlete> teams = new ArrayList<>();

        for (int i=0;i<32;i++){
            athletes.add(new PingpongAthlete("张继科"+i,"中国"));
        }

        for (int i=0;i<16;i++){
            List<Athlete> athleteList = new ArrayList<>();
            athleteList.add(athletes.get(i*2));
            athleteList.add(athletes.get(i+2+1));
            teams.add(new PingpongTeam("中国队"+i,"中国",athleteList));
        }


//        PingpongPipeline gameIndividual = new PingpongPipeline("乒乓球男单",PersonFactory.getInstance().getAthletes("Pingpong"));
//        PingpongPipeline gameTeam = new PingpongPipeline("乒乓球混双",PersonFactory.getInstance().getAthletes("PingpongTeam"));

        PingpongPipeline gameIndividual = new PingpongPipeline("乒乓球男单",pre.preCompetitionSystemFacade("Pingpong"));
        PingpongPipeline gameTeam = new PingpongPipeline("乒乓球混双",PersonFactory.getInstance().getAthletes("PingpongTeam"));


        gameIndividual.start();

    }

}
