package olympic.main.person.athlete;


/**
 * 打球的策略
 */
public interface Strategy {
    Boolean playWith(CallBack oppoent);

    void setOwnerAthlete(Athlete ownerAthlete);
}
