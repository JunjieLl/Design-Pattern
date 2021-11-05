package olympic.main.person.athlete;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.CallBack;

/**
 * 打球的策略
 */
public interface Strategy {
    Boolean playWith(CallBack oppoent);

    void setOwnerAthlete(Athlete ownerAthlete);
}
