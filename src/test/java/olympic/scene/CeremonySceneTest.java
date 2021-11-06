package olympic.scene;

import olympic.main.director.Director;
import olympic.main.director.Mode;
import olympic.main.director.Sleep;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.List;

/**
 * 测试CeremonyScene场景
 */
@DisplayName("颁奖典礼场景")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CeremonySceneTest {

    /**
     * 用于替换System.in的InputStream
     */
    private final InputStream systemIn = System.in;

    /**
     * 用于替换System.out的OutputStream
     */
    private final PrintStream systemOut = System.out;

    /**
     * 自定的测试值
     */
    private ByteArrayInputStream testIn;

    /**
     *
     * @param data 测试输入的值
     */
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }


    /**
     * 恢复系统的输入输出
     */
    @AfterAll
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    /**
     * 测试该场景用户输入1
     */
    @Test
    void testPlay_case1() {

        Sleep.setNeedSleep(false);

        Mode.setNeedDetail(false);
        //获取比赛
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        String gameName = gameNames.get(1);
        List<Athlete> athletes = personFactory.getAthletes(gameName);

        //获取获奖运动员
        athletes.get(1).setRank(gameName, 1);
        athletes.get(2).setRank(gameName, 2);
        athletes.get(3).setRank(gameName, 3);

        //创建Scene，测试play方法
        CeremonyScene ceremonyScene = new CeremonyScene(athletes);

        final String testString = "1\n\n\n";
        provideInput(testString);
        ceremonyScene.play();
        System.out.println("Test case 1 succeed.");

    }

    /**
     * 测试该场景用户输入2
     */
    @Test
    void testPlay_case2() {
        Sleep.setNeedSleep(false);
        Mode.setNeedDetail(false);

        //获取比赛
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        String gameName = gameNames.get(1);
        List<Athlete> athletes = personFactory.getAthletes(gameName);

        //获取获奖运动员
        athletes.get(1).setRank(gameName, 1);
        athletes.get(2).setRank(gameName, 2);
        athletes.get(3).setRank(gameName, 3);

        //创建Scene，测试play方法
        CeremonyScene ceremonyScene = new CeremonyScene(athletes);

        final String testString = "2\n\n\n";
        provideInput(testString);
        ceremonyScene.play();
        System.out.println("Test case 2 succeed.");

    }

    /**
     * 测试该场景用户输入3
     */
    @Test
    void testPlay_case3() {
        Sleep.setNeedSleep(false);
        Mode.setNeedDetail(false);

        //获取比赛
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        String gameName = gameNames.get(1);
        List<Athlete> athletes = personFactory.getAthletes(gameName);

        //获取获奖运动员
        athletes.get(1).setRank(gameName, 1);
        athletes.get(2).setRank(gameName, 2);
        athletes.get(3).setRank(gameName, 3);

        //创建Scene，测试play方法
        CeremonyScene ceremonyScene = new CeremonyScene(athletes);

        final String testString = "3\n\n\n";
        provideInput(testString);
        ceremonyScene.play();
        System.out.println("Test case 3 succeed.");

    }

    /**
     * 测试该场景用户输入4
     */
    @Test
    void testPlay_case4() {
        Sleep.setNeedSleep(false);
        Mode.setNeedDetail(false);

        //获取比赛
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        String gameName = gameNames.get(1);
        List<Athlete> athletes = personFactory.getAthletes(gameName);

        //获取获奖运动员
        athletes.get(1).setRank(gameName, 1);
        athletes.get(2).setRank(gameName, 2);
        athletes.get(3).setRank(gameName, 3);

        //创建Scene，测试play方法
        CeremonyScene ceremonyScene = new CeremonyScene(athletes);

        final String testString = "4\n\n\n";
        provideInput(testString);
        ceremonyScene.play();
        System.out.println("Test case 4 succeed.");

    }

    /**
     * 测试该场景用户的其他输入
     */
    @Test
    void testPlay_case_other() {
        Sleep.setNeedSleep(false);
        Mode.setNeedDetail(false);

        //获取比赛
        PersonFactory personFactory = PersonFactory.getInstance();
        List<String> gameNames = personFactory.getNames();
        String gameName = gameNames.get(1);
        List<Athlete> athletes = personFactory.getAthletes(gameName);

        //获取获奖运动员
        athletes.get(1).setRank(gameName, 1);
        athletes.get(2).setRank(gameName, 2);
        athletes.get(3).setRank(gameName, 3);

        //创建Scene，测试play方法
        CeremonyScene ceremonyScene = new CeremonyScene(athletes);

        final String testString = "随便输入\n";
        provideInput(testString);
        ceremonyScene.play();
        System.out.println("Test other case(s) succeed.");

    }


}