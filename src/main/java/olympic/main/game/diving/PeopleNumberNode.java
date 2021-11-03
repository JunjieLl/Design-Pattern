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
        System.out.println("classname: (PeopleNumberNode) method: (interpret) action: (解释器模式下获取比赛要用的评分规则) ");
        if(context.contains("Board-DivingTeam")){
            AbstractNode next =new DoublePeopleNode();
            return next.interpret(context);
        }else if(context.contains("Board-Diving")){
            AbstractNode next =new SinglePeopleNode();
            return next.interpret(context);
        }
        return null;
    }
}
