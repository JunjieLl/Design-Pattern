package olympic.scene;

import olympic.main.director.Mode;
import olympic.main.drawlots.PaperDrawLotsImpl;
import olympic.main.drawlots.RandomDrawLots;
import olympic.main.game.diving.*;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.picture.OutputPicture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("跳水比赛场景")
class DivingGameSceneTest {
    /**
     * 测试DivingGameSceneTest.play()方法
     */
    @Test
    void testPlay() {
        Mode.setNeedDetail(false);
        String game = "Three-Meter-Board-Diving";
        DivingPipeline divingGame = new DivingPipeline(game, PersonFactory.getInstance().getAthletes(game));
        AbstractNode strategyNode = new PeopleNumberNode();
        RandomDrawLots drawLots = new RandomDrawLots(PersonFactory.getInstance().getAthletes(game), new PaperDrawLotsImpl(), 1, true);
        List<Athlete> randomSortedAthletes = drawLots.randomDrawLots();
        AthletePool athletePool = new AthletePool(strategyNode.interpret(game), randomSortedAthletes);
        OutputPicture.printPictureOf(11);
        System.out.println("选手入场完毕,马上开始比赛！");
        PreliminaryContest preliminaryContest = new PreliminaryContest();
        DivingGame semiFinalContest = new SemiFinals();
        DivingGame finalContest = new FinalContest();
        divingGame.addContest(preliminaryContest);
        divingGame.addContest(semiFinalContest);
        divingGame.addContest(finalContest);
        preliminaryContest.takePlace(athletePool);
    }
}
