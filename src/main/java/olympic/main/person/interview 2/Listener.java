package olympic.main.person.interview;

/**
 * Observer接口
 * 使用的设计模式：
 * 1. Observer
 */
public interface Listener {
    /**
     * 通知Observer更新
     *
     * @param content 通知内容
     */
    void update(String content);
}
