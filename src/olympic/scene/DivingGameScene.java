package olympic.scene;

import olympic.main.game.diving.ContestPipeline;
import olympic.main.person.PersonFactory;

public class DivingGameScene implements Scene{
    @Override
    public void play(){
        String context = "下面进行的是单人十米板跳水比赛";
        ContestPipeline divingGame=new ContestPipeline(context, PersonFactory.getInstance().getAthletes("Diving"));
        divingGame.start();
    }
}
