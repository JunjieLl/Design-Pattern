package olympic.main.opening.deliverspeech;

import olympic.utils.PrintBlockFormat;
import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 教练类
 */
public class Coach extends Interviewee implements Speechable, Listener {

    /**
     * 教练问题对应的回答
     */
    private final static Map<String, List<String>> questionsToAnswers = new HashMap<>();

    static {
        questionsToAnswers.put("给大家打个招呼吧！", List.of("大家好！", "作为教练很高兴见到大家！"));
        questionsToAnswers.put("觉得今天自己执教的队员们发挥得怎样？", List.of("他们在场上拼尽了全力，我为他们感到骄傲。"));
        questionsToAnswers.put("对自己执教的这支队伍的期待是什么？", List.of("希望我与我的队员们付出的努力得到回报！"));
        questionsToAnswers.put("有什么想对自己的粉丝说的？", List.of("作为教练，感谢你们一直以来的支持！请继续支持我们的队伍！"));
        questionsToAnswers.put("现在心情怎么样？", List.of("我为我的队员们感到骄傲。"));
    }

    /**
     * Coach的构造方法
     * @param name 教练名
     * @param nation 教练国家
     */
    public Coach(String name, String nation) {
        super(name, nation);
    }

    /**
     * 获取教练问题的答案
     * @param content 问题
     * @return 教练问题的答案
     */
    @Override
    public List<String> getAnswers(String content) {
        if(questionsToAnswers.containsKey(content)) {
            return questionsToAnswers.get(content);
        } else {
            return List.of("这个问题应该由我执教的队员们回答。");
        }
    }

    /**
     * 通知教练类
     * @param content 通知内容
     */
    @Override
    public void update(String content) {
        memory.add(content);
    }

    /**
     * 开/闭幕式发言方法
     */
    public void deliverSpeech(){
        PrintBlockFormat.getPrintFormat().addString("大家好，我是Coach"+this.getName()+",我会严格遵循竞赛规则和裁判员纪律！");
    }


}
