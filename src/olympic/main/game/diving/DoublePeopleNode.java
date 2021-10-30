package olympic.main.game.diving;

/**
 * 策略模式下的终结符，用来确定比赛中的起跳高度
 */
public class DoublePeopleNode implements AbstractNode{
    @Override
    public Strategy interpret(String context){
        if(context.contains("三米")){
            System.out.println("本次比赛使用三米板双人规则");
            return new DoubleThreeMetreStrategy();
        }else if(context.contains("十米")){
            System.out.println("本次比赛使用十米台双人规则");
            return new DoubleTenMetreStrategy();
        }
        return null;
    }
}
