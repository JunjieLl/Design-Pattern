package olympic.main.person.athlete;

import olympic.main.person.athlete.torchbarer.TorchBarer;
import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Listener;

import java.util.*;

/**
 * 运动员抽象类，用于存储其运动员得分、姓名、国家等信息
 */
public abstract class Athlete extends Interviewee implements Listener, TorchBarer {
    private final static Map<String, List<String>> questionsToAnswers = new HashMap<>();

    static {
        questionsToAnswers.put("给大家打个招呼吧！", List.of("大家好！", "很高兴见到大家！"));
        questionsToAnswers.put("你对对手有什么想说的？", List.of("祝他好好发挥！"));
        questionsToAnswers.put("你觉得谁最可能夺冠？", List.of("在奥运会这种级别的赛场上，任何人都有可能夺冠。"));
        questionsToAnswers.put("今天状态如何？", List.of("感觉还不错。"));
        questionsToAnswers.put("对自己的期待是什么？", List.of("希望自己能正常发挥，为国争光！"));
        questionsToAnswers.put("今天自己发挥如何？", List.of("今天发挥正常。"));
        questionsToAnswers.put("今天对手发挥如何？", List.of("对手的表现是现象级的。"));
        questionsToAnswers.put("有什么想对自己的粉丝说的？", List.of("感谢你们一直以来的支持！"));
        questionsToAnswers.put("现在心情怎么样？", List.of("我感到很平静。"));
    }

    protected HashMap<String, Integer> rank = new HashMap<>();

    /**
     * 构造函数
     * @param name 名字
     * @param nation 国家
     */
    public Athlete(String name, String nation) {
        super(name, nation);
    }

    /**
     * 获取名字
     * @return 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 获取国家
     * @return 国家
     */
    public String getNation() {
        return nation;
    }

    /**
     * 获取排名
     * @param game 要获取的排名所在的比赛名称
     * @return 排名
     */
    public Integer getRank(String game) {
        return rank.getOrDefault(game, 0);
    }

    /**
     * 设置排名
     * @param game 比赛
     * @param rank 排名
     */
    public void setRank(String game, Integer rank) {
        this.rank.put(game, rank);
    }

    /**
     * 获取回答
     * @param content 问题
     * @return 回答
     */
    @Override
    public List<String> getAnswers(String content) {
        if (questionsToAnswers.containsKey(content)) {
            return questionsToAnswers.get(content);
        } else {
            return List.of("这个问题应该由我的教练回答");
        }
    }

}
