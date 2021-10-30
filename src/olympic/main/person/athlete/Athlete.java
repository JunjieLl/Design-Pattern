package olympic.main.person.athlete;

import olympic.main.game.Game;


/**
 * 运动员接口
 */
public interface Athlete {
    /**
     * 运动员参与比赛
     * @param game 具体的比赛
     */
    public void participate(Game game) throws Exception;
}



