package olympic.main.game;

/**
 * 比赛类接口，比赛中可能有子比赛
 */
public abstract class Game {
    public abstract void start();

    public void addChild(Game game) {
        throw new UnsupportedOperationException();
    }

    public abstract String getName();

    public abstract void play();
}
