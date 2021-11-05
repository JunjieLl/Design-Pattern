package olympic.scene;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.drawlots.PaperDrawLotsImpl;
import olympic.main.drawlots.RandomDrawLots;
import olympic.main.game.diving.*;
import olympic.main.interview.builder.InternetReportBuilder;
import olympic.main.interview.builder.NewspaperBuilder;
import olympic.main.interview.questionstrategy.AfterInterviewCoachStrategy;
import olympic.main.opening.deliverSpeech.Coach;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Interviewer;
import olympic.main.person.interview.Listener;
import olympic.picture.OutputPicture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("跳水比赛场景")
public class DivingGameScene {
    /**
     * 测试DivingGameScene.play()方法
     */
    @Test
    void testPlay() {
        String game="Three-Meter-Board-Diving";
        DivingPipeline divingGame=new DivingPipeline(game, PersonFactory.getInstance().getAthletes(game));
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
