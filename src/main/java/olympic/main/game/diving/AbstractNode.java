package olympic.main.game.diving;

/**
 * 解释器模式
 */
public interface AbstractNode {
    /**
     * 分析语法
     * @param context 要分析的语法
     * @return 要使用的策略
     */
    Strategy interpret(String context);
}
