package olympic.main.game.diving;

/**
 * 策略模式下的非终结符，用来判断一组运动员人数
 */
public class PeopleNumberNode implements AbstractNode{
    /**
     * 分析语法函数
     * @param context 要分析的语法
     * @return 下一个分析的字符
     */
    @Override
    public Strategy interpret(String context){
        if(context.contains("双人")){
            AbstractNode next =new DoublePeopleNode();
            return next.interpret(context);
        }else if(context.contains("单人")){
            AbstractNode next =new SinglePeopleNode();
            return next.interpret(context);
        }
        return null;
    }
}
