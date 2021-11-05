package olympic.main.person.athlete.badminton;

import olympic.main.person.athlete.CallBack;

/**
 * Badmintonathlete和BadmintonTeam继承
 */
public interface PlayBadminton extends CallBack {

    /**
     * 对打
     * @param oppoent 对手
     * @return 是否打赢
     */
Boolean playWith(CallBack oppoent);

    /**
     * 发球
     */
void serve();

    /**
     * 返回运动员的实力
     * @return 实力
     */
 Integer getCapacity();

}
