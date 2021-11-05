package olympic.main.opening.deliverSpeech;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

import java.util.List;

/**
 * 子类改写，第32届奥运会闭幕式
 */

public class Speech32thClose extends DeliverSpeech {   //具体子类

    List<Chairman> chairmans = PersonFactory.getInstance().getChairmans();
    Chairman OOCP = chairmans.get(0);
    Chairman IOCP = chairmans.get(1);
    Chairman HP = chairmans.get(2);
    TeamAthlete tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation("CHN"), "CHN");
    public Athlete athleteRepre = tempList.getFirstAthlete();
    Coach coachRepre = PersonFactory.getInstance().getCoach();

    /**
     * 重写函数，获取奥运会届数
     * @return 运动会届数
     */
    @Override
    String time() {
        return "32";
    }

    /**
     * 重写钩子方法的判断函数，设定是闭幕式
     * @return true为开幕式，false为闭幕式
     */
    @Override
    public boolean isOpen() {
        return false;
    }

    /**
     * 重写方法，获取OOCP的名字
     * @return 奥运会组委会主席名字
     */
    @Override
    String getOOCP() {
        return OOCP.getName();
    }

    /**
     * 重写方法，获取IOCP的名字
     * @return 国际奥委会主席名字
     */
    @Override
    String getIOCP() {
        return IOCP.getName();
    }

    /**
     * 重写方法，获取HP的名字
     * @return 东道主国家元首名字
     */
    @Override
    String getHP() {
        return HP.getName();
    }

    /**
     * 重写方法，获取运动员代表的名字
     * @return 运动员代表名字
     */
    @Override
    String getAthleteRepre() {
        return athleteRepre.getName();
    }

    /**
     * 重写方法，获取教练员代表的名字
     * @return 裁判员代表名字
     */
    @Override
    String getCoachRepre() {
        return coachRepre.getName();
    }

    @Override
    /**
     * 标记接口模式，用于检查是否能够发言
     */
    void getOOCPSpeech() {
        if (OOCP instanceof Speechable) {
            OOCP.deliverSpeech();
        } else {
            throw new UnSpeachAble();
        }
    }

    /**
     * 重写函数，获取IOCP的讲话
     */
    @Override
    void getIOCPSpeech() {
        if (IOCP instanceof Speechable) {
            IOCP.deliverSpeech();
        } else {
            throw new UnSpeachAble();
        }
    }

    /**
     * 重写函数，获取HP的讲话
     */
    @Override
    void getHPSpeech() {
        if (HP instanceof Speechable) {
            HP.deliverSpeech();
        } else {
            throw new UnSpeachAble();
        }

    }

}
