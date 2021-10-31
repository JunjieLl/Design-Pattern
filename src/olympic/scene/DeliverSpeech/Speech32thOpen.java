package olympic.scene.DeliverSpeech;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;

public class Speech32thOpen extends DeliverSpeech {  //具体子类
    @Override
    String time() {
        return "32";
    }

    /**
     * 设置其为开幕式
     */
    @Override
    public boolean isOpen() {
        return true;
    }

//    Chairman OOCP = getObject("武藤敏郎") ;
//    Chairman IOCP = getObject("武藤敏郎") ;
//    Chairman HP = getObject("武藤敏郎") ;
//    TeamAthlete tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("CHN"),"CHN");
//    public Athlete athleteRepre=tempList.getFirstAthlete();
//    Coach coachRepre = getObject("Amazon");

}
