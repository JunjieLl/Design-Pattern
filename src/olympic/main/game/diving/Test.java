package olympic.main.game.diving;

public class Test {
    public static void main(String[] args) {
        String context = "下面进行的是双人三米板跳水比赛，请各位运动员做好入场准备";
        System.out.println(context);
        AbstractNode strategyNode = new PeopleNumberNode();
        AthletePool athletePool = new AthletePool(strategyNode.interpret(context));//可以调整不同的策略，来适应不同的比赛
        for (int i = 0; i < 64; i+=2) {//测试加入
            Athlete athlete1 = new Athlete("ljj" + i);
            Athlete athlete2 = new Athlete("ljj" + (i+1));
            DoubleAthlete athletes =new DoubleAthlete();
            athletes.addAthlete(athlete1);
            athletes.addAthlete(athlete2);
            athletePool.add(athletes);
        }
        System.out.println("选手入场完毕,马上开始比赛！");
        Contest preliminaryContest=new PreliminaryContest();
        ContestPipeline divingPipeline=new ContestPipeline(preliminaryContest);
        Contest semiFinalContest=new SemiFinals();
        Contest finalContest=new FinalContest();
        divingPipeline.addContest(semiFinalContest);
        divingPipeline.addContest(finalContest);
        divingPipeline.startGame(athletePool);
    }
}
