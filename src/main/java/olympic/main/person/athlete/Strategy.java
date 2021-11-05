package olympic.main.person.athlete;


/**
 * 打球的策略
 */
public interface Strategy {
    /**
     *
     * @param oppoent 对手
     * @return 是否赢了
     */
    Boolean playWith(CallBack oppoent);

    /**
     * 设置使用此策略的运动员
     * @param ownerAthlete 运动员
     */
    void setOwnerAthlete(Athlete ownerAthlete);
}
