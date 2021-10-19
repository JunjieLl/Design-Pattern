package director.olympic;

/**
 *导演单例类
 */
public class Director {
    private Director() {
    }

    private static Director director = new Director();

    /**
     *
     * @return 返回单例导演对象
     */
    public static Director getInstance() {
        return director;
    }

    /**
     *
     * @param scene 切换到下一场景，模版方法
     */
    public void nextScene(Scene scene) {
        scene.play();
    }
}
