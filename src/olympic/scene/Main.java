package olympic.scene;

import olympic.main.person.athlete.Athlete;

public class Main {
    public static void main(String[] args) {
        Director.getInstance().nextScene(() -> System.out.println("奥林匹克运动会开始了！"));
        //FootballStarter.start();

        Scene divingGame=new DivingGameScene("单人三米");
        divingGame.play();
//        new FootballScene().play();
        //new CeremonyScene("LI JUNJIE","LI JIEJUN","JIE LIJUN").play();
        //new ChoreHandlingScene().play();
        new TrackGameScene("Marathon").play();
        new TrackGameScene("Sprints").play();
        new TrackGameScene("Hurdling").play();
        new TrackGameScene("Relays").play();
        new PingpongGameScene().play();
        //new ReviewQScene().play();


    }
}