package olympic.scene;

public class Main {
    public static void main(String[] args) {
        new CeremonyScene("LI JUNJIE","LI JIEJUN","JIE LIJUN").play();

        new ChoreHandlingScene().play();
        new ReviewQScene().play();

        new PingpongGameScene().play();
        new FootballScene().play();
    }
}
