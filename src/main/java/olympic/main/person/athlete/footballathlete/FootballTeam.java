package olympic.main.person.athlete.footballathlete;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;
import java.util.List;

/**
 * 足球队
 */
public class FootballTeam extends TeamAthlete {

    /**
     * 用于生成球队ID
     */
    private static int uid = 0;

    /**
     * 生成ID
     * @return ID
     */
    private static int generateId() {
        return uid++;
    }

    /**
     * 球队ID
     */
    private final int id;

    /**
     * 构造函数
     * @param name 球队名称
     * @param nation 国家或地区
     * @param athleteList 运动员列表
     */
    public FootballTeam(String name, String nation, List<Athlete> athleteList) {
        super(name, nation, athleteList);
        this.id = generateId();
    }

    /**
     * 获取球队的ID
     * @return 球队ID
     */
    public int getId() {
        return id;
    }



}
