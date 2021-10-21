package olympic.main.game;

/**
 * 比赛类接口，比赛中可能有子比赛
 */
public interface Game {
    public void start();

    default public void addChild(Game game) {
        throw new UnsupportedOperationException();
    }

    public String getName();
}
