package olympic.main.game.badminton;

import olympic.main.game.AbstractPipeline;
import olympic.main.game.Valve;
import olympic.main.person.athlete.Athlete;
import olympic.scene.CeremonyScene;

import java.util.ArrayList;
import java.util.List;

/**
 * 粒度最大的比赛类（比赛流水线，包括预赛复赛决赛）
 * 例如这个类可以实例化为乒乓球男单比赛
 */
public class BadmintonPipeline implements AbstractPipeline {

    /**
     * 第一个过滤器
     */
    private BadmintonFilter firstGame;

    /**
     * 最后一个过滤器
     */
    private BadmintonFilter lastGame;

    /**
     * 名字
     */
    private String name;

    /**
     * 运动员列表
     */
    private List<Athlete> athletes;


    /**
     * 比赛的前三名
     */
    private List<Athlete> topThreeAthletes = new ArrayList<>();

    /**
     * 获取前三名
     * @return 前三名
     */
    public List<Athlete> getTopThreeAthletes() {
        return topThreeAthletes;
    }

    /**
     * 构造函数
     * @param name 名字
     * @param athleteList 运动员列表
     */
    public BadmintonPipeline(String name, List<Athlete> athleteList) {
        this.name = name;
        this.athletes = athleteList;

        if (athleteList.size() == 32) {
            addContest(new BadmintonFilter("32进16"));
        }
        addContest(new BadmintonFilter("16进8"));
        addContest(new BadmintonFilter("四分之一决赛"));
        addContest(new BadmintonFilter("半决赛"));
        addContest(new BadmintonFilter("决赛"));
        firstGame.setAthletes(athletes);
    }

    /**
     * 获取名字
     * @return 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 季军赛
     */
    public Athlete thirdGame(){
        List<Athlete> thirdGameAthletes = new ArrayList<>();
        for (Athlete athlete:athletes){
            if (athlete.getRank("半决赛") == 2){
                thirdGameAthletes.add(athlete);
            }
        }
        BadmintonFilter thirdGame = new BadmintonFilter("季军赛");
        thirdGame.setAthletes(thirdGameAthletes);
        thirdGame.start();
        for (Athlete athlete:athletes){
            if (athlete.getRank("季军赛") == 1){
                return athlete;
            }
        }
        return null;
    }

    /**
     * 添加比赛
     * @param newGame 比赛
     */
    @Override
    public void addContest(Valve newGame) {
        if (firstGame == null) {
            firstGame =  (BadmintonFilter)newGame;
            lastGame = firstGame;
        } else {
            lastGame.setNext(newGame);
            lastGame = (BadmintonFilter)newGame;
        }
    }

    /**
     * 对外接口，开始比赛
     */
    @Override
    public void start() {
        System.out.println("【"+name+"开始】");

        firstGame.start();  // 管道模式的开始比赛，实际上跑了整个比赛

        // 打印比赛结果
        for (Athlete athlete:athletes){
            if (athlete.getRank("决赛") == 1){
                topThreeAthletes.add(athlete);
                break;
            }
        }
        for (Athlete athlete : athletes) {
            if (athlete.getRank("决赛") == 2) {
                topThreeAthletes.add(athlete);
                break;
            }
        }
        topThreeAthletes.add(thirdGame());
    }
}
