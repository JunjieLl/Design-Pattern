package olympic.scene;

public class Main {
    public static void main(String[] args) {
        Director.getInstance().nextScene(() -> System.out.println("奥林匹克运动会开始了！"));
        //FootballStarter.start();

        Scene divingGame=new DivingGameScene("单人三米");
        divingGame.play();
        //new CeremonyScene("LI JUNJIE","LI JIEJUN","JIE LIJUN").play();
        //new ChoreHandlingScene().play();
        //new ReviewQScene().play();
        new PingpongGameScene().play();
    }
}