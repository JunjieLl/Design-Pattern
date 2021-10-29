package olympic.main.person.athlete;

import olympic.main.game.Game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 团体射击运动员
 */
public abstract class TeamAthlete implements Athlete {
    /**
     * list每一个元素为一个个人运动员
     */
    protected List<IndividualAthlete> athleteList = new ArrayList<>();
    protected String nation;
    protected String name;

    public TeamAthlete(String nation) {
        this.nation = nation;
    }
    public TeamAthlete(String nation,String name) {
        this.nation = nation;
        this.name = name;
    }

    public String getNation() {
        return nation;
    }
    public String getName() {
        return name;
    }

    /**
     *
     * @return 返回团队运动员列表
     */
    public List<IndividualAthlete> getAthleteList(){
        return athleteList;
    }
}
