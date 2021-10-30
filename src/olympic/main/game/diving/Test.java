package olympic.main.game.diving;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.divingathlete.DivingAthlete;
import olympic.main.person.athlete.divingathlete.DivingTeam;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        String context = "下面进行的是单人十米板跳水比赛，请各位运动员做好入场准备";
        ContestPipeline divingGame=new ContestPipeline(context, PersonFactory.getInstance().getAthletes("Diving"));
        divingGame.start();
    }
}
