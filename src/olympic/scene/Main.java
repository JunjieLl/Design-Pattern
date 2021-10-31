package olympic.scene;

public class Main {
    public static void main(String[] args) {
        Director.getInstance().nextScene(new Scene() {
            @Override
            public void play() {
                System.out.println("奥林匹克运动会开始了！");
            }
        });
        //FootballStarter.start();

//        Scene divingGame=new DivingGameScene("单人三米");
//        divingGame.play();
//        new FootballScene().play();
        //new CeremonyScene("LI JUNJIE","LI JIEJUN","JIE LIJUN").play();
        //new ChoreHandlingScene().play();
        //new ReviewQScene().play();
        new PingpongGameScene().play();
    }
}