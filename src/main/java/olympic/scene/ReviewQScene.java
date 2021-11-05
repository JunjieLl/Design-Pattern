package olympic.scene;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.postgame.reviewqualification.ReviewMediatorConcrete;
import olympic.utils.PrintBlockFormat;

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
        ArrayList<String> individualGames = new ArrayList<String>();
        ArrayList<Integer> TeamIndex = new ArrayList<>();
        for (String game : games) {
            if (!game.endsWith("Team")) {
                individualGames.add(new String(game));
            }
        }

        String[] individuals = {"Marathon", "Hurdling", "Sprints"};
        int currentGameIndex = new Random().nextInt(individuals.length);
        List<Athlete> reviewee = PersonFactory.getInstance().getAthletes(individuals[currentGameIndex]);

        ArrayList<Athlete> topAthletes = new ArrayList<>();
        String currentGameRankKey = individuals[currentGameIndex];

        for (Athlete athlete : reviewee) {
            if (athlete.getRank(currentGameRankKey) < 4 && athlete.getRank(currentGameRankKey) > 0) {
                topAthletes.add(athlete);
            }
        }

        if(topAthletes.size() != 0){
            Athlete badAthlete = topAthletes.get(new Random().nextInt(topAthletes.size()));
            new ReviewMediatorConcrete(badAthlete, individualGames.get(currentGameIndex));
        }
        else{
            List<String> noProblemPrintBlock = new ArrayList<>();
            noProblemPrintBlock.add("调查管理员");
            noProblemPrintBlock.add("没有收到对比赛公正性的举报，在今后本委员会会一直监控比赛情况。");
            PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
            printBlockFormat.printFormatLeftScreen(noProblemPrintBlock, true);
        }


    }
}
