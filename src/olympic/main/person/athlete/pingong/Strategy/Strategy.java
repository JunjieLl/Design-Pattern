package olympic.main.person.athlete.pingong.Strategy;

import olympic.main.person.athlete.Athlete;

/**
 * 打球的策略
 */
public interface Strategy {
    Boolean playWith(Athlete oppoent);
    void setOwnerAthlete(Athlete ownerAthlete);
}
