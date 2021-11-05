package olympic.main.opening.deliverSpeech;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.TeamAthlete;

import java.util.List;

public class Speech32thOpen extends DeliverSpeech {  //具体子类


    /**
     * 设置其为开幕式
     */
    @Override
    public boolean isOpen() {
        return true;
    }

    List<Chairman> chairmans = PersonFactory.getInstance().getChairmans();
    Chairman OOCP = chairmans.get(0);
    Chairman IOCP = chairmans.get(1);
    Chairman HP = chairmans.get(2);
    TeamAthlete tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("CHN"), "CHN");
    public Athlete athleteRepre = tempList.getFirstAthlete();
    Coach coachRepre = PersonFactory.getInstance().getCoach();

    @Override
    String time() {
        return "32";
    }

    @Override
    String getOOCP() {
        return OOCP.getName();
    }

    @Override
    String getIOCP() {
        return IOCP.getName();
    }

    @Override
    String getHP() {
        return HP.getName();
    }

    @Override
    String getAthleteRepre() {
        return athleteRepre.getName();
    }

    @Override
    String getCoachRepre() {
        return coachRepre.getName();
    }

    @Override
    void getOOCPSpeech() {
        if (OOCP instanceof Speechable) {
            OOCP.deliverSpeech();
        } else {
            throw new UnSpeachAble();
        }
    }

    @Override
    void getIOCPSpeech() {
        if (IOCP instanceof Speechable) {
            IOCP.deliverSpeech();
        } else {
            throw new UnSpeachAble();
        }


    }

    @Override
    void getHPSpeech() {
        if (HP instanceof Speechable) {
            HP.deliverSpeech();
        } else {
            throw new UnSpeachAble();
        }

    }

    @Override
    void getAthleteRepreSpeech() {
        if (athleteRepre instanceof Speechable) {
            athleteRepre.deliverSpeech();
        } else {
            throw new UnSpeachAble();
        }

    }

    @Override
    void getCoachRepreSpeech() {
        if (coachRepre instanceof Speechable) {
            coachRepre.deliverSpeech();
        } else {
            throw new UnSpeachAble();
        }

    }
}
