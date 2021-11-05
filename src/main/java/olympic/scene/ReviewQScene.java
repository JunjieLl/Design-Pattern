package olympic.scene;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.postgame.review_qualification.ReviewMediatorConcrete;
import olympic.scene.Scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 检查比赛资质（Qualification）的场景.
 */
public class ReviewQScene implements Scene {

    @Override
    public void play() {
        List<String> games = PersonFactory.getInstance().getNames();
        ArrayList<String> individualGames = new ArrayList<String>();
        ArrayList<Integer> TeamIndex = new ArrayList<>();
        for (String game : games) {
            if (!game.endsWith("Team")) {
                individualGames.add(game);
            }
        }

        String[] individuals = {"Marathon", "Hurdling", "Diving", "Sprints", "Pingpong"};
        int currentGameIndex = new Random().nextInt(individuals.length);
        List<Athlete> reviewee = PersonFactory.getInstance().getAthletes(individuals[currentGameIndex]);

        ArrayList<Athlete> topAthletes = new ArrayList<>();
        String currentGameRankKey = individuals[currentGameIndex];

        ArrayList<String> PingpongDiving = new ArrayList<>();
        PingpongDiving.add("Pingpong");
        PingpongDiving.add("Diving");

        if (PingpongDiving.contains(currentGameRankKey)) {
            for (Athlete athlete : reviewee) {
                if (athlete.getRank("决赛") < 4 && athlete.getRank("决赛") > 0) {
                    topAthletes.add(athlete);
                }
            }
        } else {
            for (Athlete athlete : reviewee) {
                if (athlete.getRank(currentGameRankKey) < 4 && athlete.getRank(currentGameRankKey) > 0) {
                    topAthletes.add(athlete);
                }
            }
        }
        Athlete badAthlete = topAthletes.get(new Random().nextInt(topAthletes.size()));
        new ReviewMediatorConcrete(badAthlete, individualGames.get(currentGameIndex));
    }
}
