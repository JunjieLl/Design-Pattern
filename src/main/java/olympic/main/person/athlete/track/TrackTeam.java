package olympic.main.person.athlete.track;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

import java.util.List;

/**
 * 跑步运动员组合
 */
public class TrackTeam extends TeamAthlete{
    /**
     * 构造函数
     * @param name 名称
     * @param nation 国家
     * @param athleteList 运动员列表
     */
    public TrackTeam(String name, String nation, List<Athlete> athleteList) {
        super(name, nation, athleteList);
    }
}
