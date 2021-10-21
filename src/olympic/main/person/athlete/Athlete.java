package olympic.main.person.athlete;

import olympic.main.game.Game;


/**
 * 运动员接口，运动员可能作为团体Composite
 */
public interface Athlete {
    public void participate(Game game);

    default public void addChild(Athlete athlete) {
        throw new UnsupportedOperationException();
    }
}



