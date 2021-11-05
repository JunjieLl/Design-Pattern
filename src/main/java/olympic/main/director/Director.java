package olympic.main.director;

import olympic.main.person.PersonFactory;
import olympic.picture.OutputPicture;
import olympic.scene.*;
import olympic.voiceover.OutputVoiceover;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 * 导演
 * 设计模式：Singleton
 */
final public class Director {
    private Director() {
        Map<String, List<String>> tempGameNames = PersonFactory.getInstance().getCatalogueMap();
        for (String name : tempGameNames.keySet()) {
            gameNames.put(name, new ArrayList<>(tempGameNames.get(name)));
        }
    }

    private static Director director;

    /**
     * 设计模式：Lazy Loading
     *
     * @return 返回单例导演对象
     */
    public static Director getInstance() {
        System.out.println("classname: (Director) method: (getInstance) action: (获取单例类实例) ");
        if (null == director) {
            System.out.println("classname: (Director) method: (getInstance) action: (惰性加载获取单例类实例) ");
            director = new Director();
        }
        return director;
    }

    /**
     * 设计模式： Template Method
     * 切换到下一场景
     *
     * @param scene 下一个场景
     */
    final public void nextScene(Scene scene) {
        System.out.println("classname: (Director) method: (nextScene) action: (切换到下一场景) ");
        scene.play();
    }

    private Map<String, List<String>> gameNames = new HashMap<>();

    private Scanner input = new Scanner(System.in);

    private PrintStream screen = System.out;


    /**
     * 出处重定向用
     * @param target 输出到哪，两个选项
     *               screen 输出到屏幕
     *               其他 输出到文件
     */
    private void changeOutputTarget(String target) {
        if (target.equals("screen")) {
            System.setOut(screen);
        } else {
            try {
                System.setOut(new PrintStream("out.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 赛前场景顺序执行
     */
    private void startBeforeGameActivities() {
        OutputPicture.printPictureOf(1);
        OutputPicture.printPictureOf(2); //flag
        OutputVoiceover.printVoiceoverOf(1);
//        new TicketCheckingScene().play(); 跳不出来死循环
        OutputVoiceover.printVoiceoverOf(2);
        nextScene(new ProtectionFactoryScene());
        OutputPicture.printPictureOf(3); //playground
        OutputVoiceover.printVoiceoverOf(3);
        nextScene(new TranslateScene());
        OutputPicture.printPictureOf(7); // sing
        nextScene(new PerformanceScene());
        nextScene(new OpenSpeechScene());
        OutputPicture.printPictureOf(8); // queue
        nextScene(new EnterScene());
        OutputPicture.printPictureOf(9); //fire
        nextScene(new FireworkScene());
        OutputVoiceover.printVoiceoverOf(4);
    }

    /**
     * 赛后活动顺序
     */
    private void startAfterGameActivities() {
//        new PressConferenceScene().play();  //不用在main里面调
//        new CeremonyScene().play();
        nextScene(new ChoreHandlingScene());
        OutputVoiceover.printVoiceoverOf(16);
        nextScene(new MonitorSiteScene());
        OutputVoiceover.printVoiceoverOf(17);
        nextScene(new ReviewQScene());
        OutputVoiceover.printVoiceoverOf(18);
        nextScene(new CloseSpeechScene());
        OutputPicture.printPictureOf(16);
        OutputPicture.printPictureOf(1);
    }

    /**
     * 开始一场具体比赛
     * @param className 大类名称
     */
    private void startOneGame(String className) {
        System.out.println("请输入您想观看的比赛（输入exit重新选择大类）");
        while (true) {
            String gameName = input.next();
            if (gameName.equals("exit")) {
                return;
            } else if (!gameNames.get(className).contains(gameName)) {
                System.out.println("比赛名有误，请重新输入：");
                continue;
            }
            Scene scene = SceneFactory.getScene(gameName);
            if (scene != null) {
                scene.play();
                gameNames.get(className).remove(gameName);
                if (gameNames.get(className).size() == 0) {
                    gameNames.remove(className);
                }
                break;
            } else {
                System.out.println("比赛名有误，请重新输入：");
            }
        }
    }

    /**
     * 用户选择exit后将剩下的比赛比完
     * 并且将输出重定向到out。txt中
     */
    private void startRemainingGames() {
        changeOutputTarget("file");
        Mode.setNeedDetail(false);
        for (List<String> nameList : gameNames.values()) {
            for (String name : nameList) {
                Scene scene = SceneFactory.getScene(name);
                if (scene != null) {
                    scene.play();
                }
            }
        }
        changeOutputTarget("screen");
    }


    /**
     * 比赛，用户选择
     */
    private void startGame() {
        while (gameNames.size() != 0) {
            System.out.println("可观看的比赛有：");
            for (String name : gameNames.keySet()) {
                System.out.println(name);
            }
            System.out.print("输入您想观看的大类(输入exit退出)：");
            String className = input.next();
            if (className.equalsIgnoreCase("exit")) {
                startRemainingGames();
                break;
            }
            List<String> names = gameNames.get(className);
            if (names != null) {
                System.out.println(className + "有以下比赛：");
                for (String name : names) {
                    System.out.println(name);
                }
                startOneGame(className);
            } else {
                System.out.print("没有此比赛，请重新选择,");
            }
        }
    }

    public void start() {
        startBeforeGameActivities();
        startGame();
        startAfterGameActivities();
    }
}

