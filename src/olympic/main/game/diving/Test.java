package olympic.main.game.diving;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.divingathlete.DivingAthlete;
import olympic.main.person.athlete.divingathlete.DoubleDivingAthlete;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Athlete> allMember=new LinkedList<>();
        String context = "下面进行的是单人十米板跳水比赛，请各位运动员做好入场准备";
        //单人测试
        for (int i = 0; i < 32; i++) {
            DivingAthlete divingAthlete = new DivingAthlete("ljj" + i,"中国");
            allMember.add(divingAthlete);
        }
        //双人测试
//        for (int i = 0; i < 64; i+=2) {
//            LinkedList<Athlete> list=new LinkedList<>();
//            DivingAthlete divingAthlete1 = new DivingAthlete("ljj" + i,"中国");
//            DivingAthlete divingAthlete2 = new DivingAthlete("ljj" + (i+1),"中国");
//            list.add(divingAthlete1);
//            list.add(divingAthlete2);
//            DoubleDivingAthlete athletes =new DoubleDivingAthlete(i+"组","中国",list);
//            allMember.add(athletes);
//        }
        ContestPipeline divingGame=new ContestPipeline(context,allMember);
        divingGame.start();
    }
}
