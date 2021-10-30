package olympic.scene;

public class Main {
    public static void main(String[] args) {
        Director.getInstance().nextScene(new Scene() {
            @Override
            public void play() {
                System.out.println("奥林匹克运动会开始了！");
            }
        });
        new FootballScene().play();
        Scene divingGame=new DivingGameScene();
        divingGame.play();
        //new CeremonyScene("LI JUNKIE","LI JEJUNE","JIE LION").play();
        //new ChoreHandlingScene().play();
        //new ReviewQScene().play();
        new PingpongGameScene().play();
    }
}