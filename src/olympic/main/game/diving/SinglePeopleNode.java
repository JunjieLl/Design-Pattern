package olympic.main.game.diving;

public class SinglePeopleNode implements AbstractNode{
    @Override
    public Strategy interpret(String context){
        if(context.contains("三米")){
            System.out.println("本次比赛使用三米板单人规则");
            return new SingleThreeMetreStrategy();
        }else if(context.contains("十米")){
            System.out.println("本次比赛使用十米台单人规则");
            return new SingleTenMetreStrategy();
        }
        return null;
    }
}
