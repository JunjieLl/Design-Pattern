package olympic.main.person.interview;

import olympic.main.person.Person;

import java.util.*;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * 被采访者
 * 使用的设计模式：
 * 1. Observer
 */
public abstract class Interviewee extends Person {
    /**
     * 停止词：{@value}
     */
    public static final String STOP_WORD = "不想回答这个问题。";

    /**
     * 新闻发布会问题的pattern
     */
    private static final String pressConferencePattern = ".*发起提问.*";

    /**
     * 观察者observers
     */
    private final List<Listener> listeners = new ArrayList<>();

    /**
     * 创造被采访者
     *
     * @param name   名字
     * @param nation 国家
     */
    protected Interviewee(String name, String nation) {
        super(name, nation);
    }

    /**
     * 获取观察者
     *
     * @return 观察者列表
     */
    public List<Listener> getListeners() {
        return listeners;
    }

    /**
     * 添加观察者
     *
     * @param listener 添加的观察者
     */
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    /**
     * 删除观察者
     *
     * @param listener 删除的观察者
     */
    public void deleteListener(Listener listener) {
        listeners.remove(listener);
    }

    /**
     * 根据问题回答问题
     *
     * @param content 问题
     * @return 对应的回答
     */
    public String answerQuestion(String content) {
        Random random = new Random();
        int stopNum = random.nextInt(10);
        if (stopNum == 0) {
            return STOP_WORD;
        } else if (Pattern.matches(pressConferencePattern, content)) {
            return "\"对问题的回答\"";
        } else {
            return pickOneAnswer(content);
        }
    }

    /**
     * 挑选一个回答
     *
     * @param content 问题
     * @return 对应的回答
     */
    public String pickOneAnswer(String content) {
        List<String> answers = getAnswers(content);
        Random random = new Random();
        int randomIndex = random.nextInt(answers.size());
        return answers.get(randomIndex);
    }

    /**
     * 获得一个问题对应的全部可能回答
     *
     * @param content 问题
     * @return 对应的全部可能回答
     */
    public abstract List<String> getAnswers(String content);

    /**
     * 通知观察者
     *
     * @param content 通知的内容（answer）
     */
    public void notifyListeners(String content) {
        for (Listener o : listeners) {
            o.update(content);
        }
    }

    /**
     * 新闻发布会发表随机数量的讲话
     *
     * @return 发表的讲话列表
     */
    public List<String> makeSpeech() {
        Random random = new Random();
        int talkNum = random.nextInt(10) + 1;
        List<String> speech = new ArrayList<>();
        for (int i = 0; i < talkNum; i++) {
            speech.add("讲话" + i);
        }
        return speech;
    }
}
