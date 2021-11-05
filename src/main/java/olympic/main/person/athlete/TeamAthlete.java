package olympic.main.person.athlete;

import java.util.ArrayList;
import java.util.List;

/**
 * 团队运动员类
 */
public class TeamAthlete extends Athlete {
    /**
     * 运动员列表
     */
    protected List<Athlete> athleteList = new ArrayList<>();

    /**
     * 构造函数
     * @param name 名字
     * @param nation 国家
     * @param athleteList 运动员列表
     */
    public TeamAthlete(String name, String nation, List<Athlete> athleteList) {
        super(name, nation);
        this.athleteList = athleteList;
    }

    /**
     * 构造函数
     * @param athleteList 运动员列表
     * @param nation 国家
     */
    public TeamAthlete(List<Athlete> athleteList, String nation) {
        super("无名", nation);
        this.athleteList = athleteList;
    }

    /**
     * 构造函数
     * @param nation 国家
     */
    public TeamAthlete(String nation) {
        super("无名", nation);
    }

    /**
     * 获取运动员列表
     * @return 运动员列表
     */
    public List<Athlete> getAthleteList() {
        return athleteList;
    }

    /**
     * 更新
     * @param content 通知内容
     */
    @Override
    public void update(String content) {
        memory.add(content);
        for (Athlete athlete : athleteList) {
            athlete.getMemory().add(content);
        }
    }

    /**
     * 传递火炬
     */
    @Override
    public void passFire() {
        for (Athlete athlete : athleteList) {
            athlete.passFire();
        }
    }

    /**
     * 获取第一个运动员
     */
    public Athlete getFirstAthlete() {
        return athleteList.get(0);
    }

    /**
     * 添加运动员
     * @param athlete 运动员
     */
    public void addMember(Athlete athlete) {
        athleteList.add(athlete);
    }

    /**
     * 获取运动员数
     * @return
     */
    public int getNumber() {
        return athleteList.size();
    }
}
