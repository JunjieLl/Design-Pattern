package olympic.main.person.athlete.pingong.strategy;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.pingong.CallBack;

/**
 * 打球的策略
 */
public interface Strategy {
    Boolean playWith(CallBack oppoent);
    void setOwnerAthlete(Athlete ownerAthlete);
}
