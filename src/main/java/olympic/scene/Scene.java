package olympic.scene;


/**
 * 复写play方法以实现场景的播放
 * 场景中可能有子场景
 */
public interface Scene {

    /**
     * 运行场景
     */
    public abstract void play();
}