package olympic.scene;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.postgame.reviewqualification.ReviewMediatorConcrete;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 检查比赛资质（Qualification）的场景.
 */
public class ReviewQScene implements Scene {

    /**
     * 检查比赛资质的主函数
     */
    @Override
    public void play() {
        List<String> games = PersonFactory.getInstance().getNames();

        List<String> individualGames = PersonFactory.getInstance().getSingalGameNames();

        int currentGameIndex = new Random().nextInt(individualGames.size());

        String targetGameName = individualGames.get(currentGameIndex);

        List<Athlete> reviewee = PersonFactory.getInstance().getAthletes(targetGameName);

        ArrayList<Athlete> topAthletes = new ArrayList<>();

        ArrayList<String> PingpongDiving = new ArrayList<>();
        PingpongDiving.add("Pingpong");
        PingpongDiving.add("Diving");
        PingpongDiving.add("Badminton");


        if (PingpongDiving.contains(targetGameName)) {
            for (Athlete athlete : reviewee) {
                if (athlete.getRank("决赛") < 4 && athlete.getRank("决赛") > 0) {
                    topAthletes.add(athlete);
                }
            }
        } else {
            for (Athlete athlete : reviewee) {
                if (athlete.getRank(targetGameName) < 4 && athlete.getRank(targetGameName) > 0) {
                    topAthletes.add(athlete);
                }
            }
        }
        Athlete badAthlete = topAthletes.get(new Random().nextInt(topAthletes.size()));
        new ReviewMediatorConcrete(badAthlete, individualGames.get(currentGameIndex));
    }
}
