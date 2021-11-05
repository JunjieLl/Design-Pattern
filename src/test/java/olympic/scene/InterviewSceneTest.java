package olympic.scene;

import olympic.main.interview.InterviewMaker;
import olympic.main.interview.builder.InternetReportBuilder;
import olympic.main.interview.builder.NewspaperBuilder;
import olympic.main.interview.questionstrategy.*;
import olympic.main.opening.deliverSpeech.Coach;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athlete.divingathlete.DivingAthlete;
import olympic.main.person.athlete.track.TrackAthlete;
import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Interviewer;
import olympic.main.person.interview.Listener;
import olympic.main.person.interview.Stopper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
 * 《Test写法》
 * 1. 写多少个test类？：
 * olympic.scene包中的scene类，每个scene写一个xxxSceneTest类，如InterviewSceneTest，每个人写自己负责的scene的test
 * class所处的package为olympic.scene，class前不加任何如public的修饰
 *
 * 2. 每个test类怎么写？：
 * 首先在class前加注解@DisplayName("xx场景")
 *
 * 注意要写Java doc注释
 *
 * - 若olympic.scene中的scene类的.play方法不需要输入交互，那么至少写一个testPlay()函数
 * 写法如InterviewSceneTest.testPlay()，方法前不加任何如public的修饰
 *
 * - 若olympic.scene中的scene类的.play方法需要输入交互，那么至少写一个test()方法
 * 在test()方法中模拟Scene的流程，但只输出不需要用户交互
 *
 * 除了testPlay()与test()方法，若还想写额外的测试方法也可以，但命名要符合testXXX规范
 *
 * 3. 怎么利用JUnit?：
 * 基本上只需要用到最基本的@Test与@DisplayName注解
 * 如果想使用更高级的assert断言等测试功能，可参考该网站写法：
 * https://junit.org/junit5/docs/current/user-guide/#writing-tests
 *
 * 4. 如何运行JUnit？
 * maven reload后右键项目名 -> Run "All Tests"
 *
 * 写法细节参照以下InterviewSceneTest类
 */

/**
 * 测试采访场景类
 * 由于作为示例写法，因此实现了全部类型的test方法（testPlay()、test()、testXXX）
 * 实际无需全写，写多少见以上《Test写法》注释
 */
@DisplayName("采访场景")
class InterviewSceneTest {
    /**
     * 测试InterviewScene.play()方法
     */
    @Test
    void testPlay() {
        // 获取听众
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        String gameName = gameNames.get(1);
        List<? extends Listener> audience = personFactory.getAthletes(gameName);

        // 赛前采访
        // 获取被采访者、采访者
        System.out.println("赛前采访开始：");
        Interviewee preInterviewee = new Coach("XMX", "中国");
        List<Interviewer> preInterviewers = new ArrayList<>();
        preInterviewers.add(new Interviewer("Junjie Li", "美国", new AfterInterviewCoachStrategy(), new NewspaperBuilder("Junjie Li", "Manxin Xu")));
        preInterviewers.add(new Interviewer("Chenhao Zhai", "英国", new AfterInterviewCoachStrategy(), new InternetReportBuilder("Chenhao Zhai", "Manxin Xu")));
        preInterviewers.add(new Interviewer("Even", "法国", new AfterInterviewCoachStrategy(), new InternetReportBuilder("Even", "Manxin Xu")));

        // 创建scene，测试play函数
        InterviewScene interviewScene = new InterviewScene(preInterviewee, preInterviewers, audience, 10);
        interviewScene.play();
    }

    /**
     * 测试InterviewScene
     */
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
        Interviewee preInterviewee = new Coach("XMX", "中国");
        List<Interviewer> preInterviewers = new ArrayList<>();
        preInterviewers.add(new Interviewer("Junjie Li", "美国", new AfterInterviewCoachStrategy(), new NewspaperBuilder("Junjie Li", "Manxin Xu")));
        preInterviewers.add(new Interviewer("Chenhao Zhai", "英国", new AfterInterviewCoachStrategy(), new InternetReportBuilder("Chenhao Zhai", "Manxin Xu")));
        preInterviewers.add(new Interviewer("Even", "法国", new AfterInterviewCoachStrategy(), new InternetReportBuilder("Even", "Manxin Xu")));

        /*
        模拟InterviewScene的流程
         */

        int maxQuestionNum = 10;
        // 添加采访者、听众、Stopper作为observer
        for (Interviewer interviewer : preInterviewers) {
            preInterviewee.addListener(interviewer);
        }
        for (Listener listener : audience) {
            preInterviewee.addListener(listener);
        }
        Stopper stopper = new Stopper("宅尘浩", "中国", maxQuestionNum);
        preInterviewee.addListener(stopper);

        // Builder模式，创建report标题
        for (Interviewer interviewer : preInterviewers) {
            var reportBuilder = interviewer.getReportBuilder();
            reportBuilder.makeTitle("");
        }

        // 用于记录已经提问的问题，防止重复提问
        ArrayList<String> historyQuestions = new ArrayList<>();

        // 随机抽取记者轮流提问，直到达到提问数量上限或者记者无问题可问
        Interviewer currentInterviewer = InterviewMaker.pickOneInterviewer(preInterviewers);
        while (stopper.shouldContinue() && currentInterviewer != null) {
            String currentQuestion = currentInterviewer.ask();
            if (!historyQuestions.contains(currentQuestion)) {
                System.out.println(currentInterviewer.getName() + "问问题：" + currentQuestion);
                String currentAnswer = preInterviewee.answerQuestion(currentQuestion);
                preInterviewee.notifyListeners(currentAnswer);
                System.out.println(preInterviewee.getName() + "回答问题：" + currentAnswer);
                historyQuestions.add(currentQuestion);
                var reportBuilder = currentInterviewer.getReportBuilder();
                reportBuilder.makeQuestion(currentQuestion);
                reportBuilder.makeAnswer(currentAnswer);
            }
            currentInterviewer = InterviewMaker.pickOneInterviewer(preInterviewers);
        }
        System.out.println('\n');

        // 攥写采访报告
        for (Interviewer interviewer : preInterviewers) {
            var reportBuilder = interviewer.getReportBuilder();
            reportBuilder.close();
            reportBuilder.showReport();
        }
    }

    /**
     * 测试Interviewee.addListener()方法
     */
    @Test
    void testAddListener() {
        Interviewee interviewee = new DivingAthlete("ljj", "中国");
        Listener interviewer = new Interviewer("zch", "中国");
        Listener individualAthlete = new TrackAthlete("xmx", "中国");
        Listener teamAthlete = new TeamAthlete("中国");
        interviewee.addListener(interviewer);
        interviewee.addListener(individualAthlete);
        interviewee.addListener(teamAthlete);
        System.out.println("Test addListener() succeed.");
    }

    @Test
    void testNotifyListeners() {
        Interviewee interviewee = new DivingAthlete("ljj", "中国");
        Listener interviewer = new Interviewer("zch", "中国", new PreInterviewAthleteStrategy());
        Listener individualAthlete = new TrackAthlete("xmx", "中国");
        Listener teamAthlete = new TeamAthlete("中国");
        interviewee.addListener(interviewer);
        interviewee.addListener(individualAthlete);
        interviewee.addListener(teamAthlete);
        interviewee.notifyListeners("大家好！");
        System.out.println("Test notifyListeners() succeed.");
    }
}
