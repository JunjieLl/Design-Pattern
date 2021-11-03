package olympic.scene;

import olympic.main.game.pingponggame.Mode;
import olympic.main.person.PersonFactory;

import java.util.*;

/**
 * 导演
 * 设计模式：Singleton
 */
public class Director {
    private Director() {
        gameNames = new ArrayList<>(PersonFactory.getInstance().getNames());
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
    public void nextScene(Scene scene) {
        System.out.println("classname: (Director) method: (nextScene) action: (切换到下一场景) ");
        scene.play();
    }

    private List<String> gameNames;

    private Map<String,List<String>> games = new HashMap<>();


    /**
     * 赛前场景顺序执行
     */
    private void startBeforeGameActivities() {
//        new TicketCheckingScene().play();
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

    /**
     * 比赛，用户选择
     */
    private void startGame() {
        while (gameNames.size() != 0) {
            System.out.println("未举行的比赛有：");
            for (String name : gameNames) {
                System.out.println(name);
            }
            System.out.print("输入您想观看的比赛(输入exit退出)：");
            Scanner input = new Scanner(System.in);

            while (true) {
                String inputName = input.next();
                if (inputName.equals("exit")) {
                    break;
                }
                Scene scene = SceneFactory.getInstance().getScene(inputName);
                if (scene != null) {
                    scene.play();
                    gameNames.remove(inputName);
                    break;
                } else {
                    System.out.print("没有此比赛，请重新选择：");
                }
            }
        }
    }

    public void start() {
        startBeforeGameActivities();
        startGame();
        startAfterGameActivities();
    }
}
