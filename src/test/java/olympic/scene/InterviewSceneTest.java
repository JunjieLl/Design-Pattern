package olympic.scene;

import olympic.main.interview.builder.InternetReportBuilder;
import olympic.main.interview.builder.NewspaperBuilder;
import olympic.main.interview.questionstrategy.PreInterviewAthleteStrategy;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.track.TrackAthlete;
import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Interviewer;
import olympic.main.person.interview.Listener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("采访场景")
class InterviewSceneTest {
    @Test
    void test() {
        // 获取听众
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        String gameName = gameNames.get(1);
        List<? extends Listener> audience = personFactory.getAthletes(gameName);

        // 赛前采访
        // 获取被采访者、采访者
        System.out.println("赛前采访开始：");
        Interviewee preInterviewee = new TrackAthlete("徐满心", "中国");
        List<Interviewer> preInterviewers = new ArrayList<>();
        preInterviewers.add(new Interviewer("Junjie Li", "美国", new PreInterviewAthleteStrategy(), new NewspaperBuilder("Junjie Li", "Manxin Xu")));
        preInterviewers.add(new Interviewer("Chenhao Zhai", "英国", new PreInterviewAthleteStrategy(), new InternetReportBuilder("Chenhao Zhai", "Manxin Xu")));
        preInterviewers.add(new Interviewer("Even", "法国", new PreInterviewAthleteStrategy(), new InternetReportBuilder("Even", "Manxin Xu")));

        // 创建scene，测试play函数
        InterviewScene interviewScene = new InterviewScene(preInterviewee, preInterviewers, audience, 10);
        interviewScene.play();
    }
}
