package olympic.scene;

/**
 * 导演
 * 设计模式：Singleton
 */
public class Director {
    private Director() {
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
     * @param scene 下一个场景
     */
    public void nextScene(Scene scene) {
        System.out.println("classname: (Director) method: (nextScene) action: (切换到下一场景) ");
        scene.play();
    }


//    private Integer state


}
