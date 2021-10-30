package olympic.main.game.diving;

public class PeopleNumberNode implements AbstractNode{
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
