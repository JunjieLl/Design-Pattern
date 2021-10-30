package olympic.main.game.diving;

/**
 * 策略模式下的终结符，用来确定比赛中的起跳高度
 */
public class SinglePeopleNode implements AbstractNode{
    @Override
    public Strategy interpret(String context){
        if(context.contains("三米")){
            System.out.println("本次比赛使用【三米板单人】规则");
            return new SingleThreeMetreStrategy();
        }else if(context.contains("十米")){
            System.out.println("本次比赛使用【十米台单人】规则");
            return new SingleTenMetreStrategy();
        }
        return null;
    }
}
