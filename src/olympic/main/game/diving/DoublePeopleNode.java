package olympic.main.game.diving;

/**
 * 策略模式下的终结符，用来确定比赛中的起跳高度
 */
public class DoublePeopleNode implements AbstractNode {

    /**
     * 分析语法函数
     *
     * @param context 要分析的语法
     * @return 要使用的策略
     */
    @Override
    public Strategy interpret(String context) {
        if (context.contains("三米")) {
            System.out.println("本次比赛使用【三米板双人】规则");
            return new DoubleThreeMetreStrategy();
        } else if (context.contains("十米")) {
            System.out.println("本次比赛使用【十米台双人】规则");
            return new DoubleTenMetreStrategy();
        }
        return null;
    }
}
