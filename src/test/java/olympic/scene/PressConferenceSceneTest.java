package olympic.scene;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.track.TrackAthlete;
import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Interviewer;
import olympic.main.person.interview.Listener;
import olympic.main.pressconference.questionstrategy.PressConferenceStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试新闻发布会场景类
 */
@DisplayName("新闻发布会场景")
class PressConferenceSceneTest {
    /**
     * 测试PressConferenceScene.play()方法
     */
    @Test
    void testPlay() {
        // 获取听众
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        System.out.println(gameNames);
        String gameName = gameNames.get(2);
        List<? extends Listener> audience = personFactory.getAthletes(gameName);

        // 获取被采访者、采访者
        Interviewee interviewee = new TrackAthlete("徐满心", "中国");
        ArrayList<Interviewer> interviewers = new ArrayList<>();
        interviewers.add(new Interviewer("Junjie Li", "美国", new PressConferenceStrategy()));
        interviewers.add(new Interviewer("Chenhao Zhai", "英国", new PressConferenceStrategy()));
        interviewers.add(new Interviewer("Even", "法国", new PressConferenceStrategy()));
        Scene pressConferenceScene = new PressConferenceScene(interviewee, interviewers, audience, 10);
        pressConferenceScene.play();
    }
}
