package main.olympic;

import java.util.ArrayList;
import java.util.List;

public class GameContainer extends Game {
    private static GameContainer gameContainer;

    private GameContainer() {

    }

    public GameContainer getInstance() {
        if (null == gameContainer) {
            gameContainer = new GameContainer();
        }
        return gameContainer;
    }

    private List<Game> gameList = new ArrayList<>();

    @Override
    public void play() {
        for (Game game : gameList) {
            game.play();
        }
    }

    public void addGame(Game game){
        gameList.add(game);
    }
}
