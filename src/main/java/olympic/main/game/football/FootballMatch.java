package olympic.main.game.football;


import olympic.main.person.athlete.footballathlete.FootballTeam;



/**
 * 一场足球比赛
 * Observer 模式
 * Template Method 模式
 */
public abstract class FootballMatch {

    /**
     * 双方球队
     */
    private FootballTeam team1, team2;

    /**
     * 双方得分
     */
    protected int score1, score2;

    /**
     * 观察者
     */
    protected Observer observer = null;

    /**
     * 构造函数
     * @param team1 球队1
     * @param team2 球队2
     */
    public FootballMatch(FootballTeam team1, FootballTeam team2) {
        super();
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = this.score2 = 0;
    }

    /**
     * 开始比赛
     */
    public void begin() {
        System.out.println("\n【足球赛事】" + team1.getName() + " vs " + team2.getName());
        System.out.println("比赛开始");
    }

    /**
     * 进行本场比赛
     */
    public void play() {
        begin();
        // 随机产生比分
        generateResult();
        notifyObserver();
    }


    /**
     * 生成比赛结果（随机生成）
     */
    public abstract void generateResult();

    /**
     * 获取球队1的得分
     * @return 球队1的得分
     */
    public int getScore1() {
        return score1;
    }

    /**
     * 获取球队2的得分
     * @return 球队2的得分
     */
    public int getScore2() {
        return score2;
    }

    /**
     * 获取球队1
     * @return 球队1
     */
    public FootballTeam getTeam1() {
        return team1;
    }

    /**
     * 获取球队2
     * @return 球队2
     */
    public FootballTeam getTeam2() {
        return team2;
    }

    /**
     * 通知观察者
     */
    public void notifyObserver() {
        if (observer != null) {
            observer.update(this);
        }
    }
}