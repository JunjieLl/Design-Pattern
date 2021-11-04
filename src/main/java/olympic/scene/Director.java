package olympic.scene;

import olympic.main.game.pingponggame.Mode;
import olympic.main.person.PersonFactory;

import java.util.*;

/**
 * 导演
 * 设计模式：Singleton
 */
final public class Director {
    private Director() {
//        gameNames = new ArrayList<>(PersonFactory.getInstance().getNames());
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

//    private List<String> gameNames;

    private Map<String, List<String>> gameNames = new HashMap<>();

    private Scanner input = new Scanner(System.in);

    /**
     * 赛前场景顺序执行
     */
    private void startBeforeGameActivities() {
//        new TicketCheckingScene().play(); 跳不出来死循环
        new ProtectionFactoryScene().play();
        new TranslateScene().play();
        new PerformanceScene().play();
        new OpenSpeechScene().play();
        new EnterScene().play();
        new FireworkScene().play();
    }

    /**
     * 赛后活动顺序
     */
    private void startAfterGameActivities() {
//        new PressConferenceScene().play();  //不用在main里面调
//        new CeremonyScene().play();
        new ChoreHandlingScene().play();
        new MonitorSiteScene().play();
        new ReviewQScene().play();
        new CloseSpeechScene().play();
    }

    private void startOneGame(String className) {
        System.out.println("请输入您想观看的比赛");
        while (true) {
            String gameName = input.next();
            if (!gameNames.get(className).contains(gameName)) {
                System.out.println("比赛名有误，请重新输入：");
                continue;
            }
            Scene scene = SceneFactory.getInstance().getScene(gameName);
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
            if (className.equals("exit")) {
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
                System.out.print("没有此比赛，请重新选择：");
            }
        }
    }

    public void start() {
        startBeforeGameActivities();
        startGame();
        startAfterGameActivities();
    }
}
