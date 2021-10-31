package olympic.main.game.diving;

import java.util.ArrayList;

public abstract class Strategy {
    protected String name;
    protected ArrayList<Double> scores;
    protected int cycleNumber;
    abstract double decideScore();
    abstract int getCycleNumber();
    public String getName(){
        return name;
    }
    public void showStrategy(String strategy){
        System.out.printf("classname: (%s) method: (%s) action: (%s)\n\n",strategy,strategy,"使用"+name+"规则");
    }
}
