package olympic.main.person.athlete.pingong;

import olympic.main.game.pingponggame.Mode;
import olympic.main.person.athlete.Athlete;

public interface PlayPingpong {
    public Boolean playWith(Athlete oppoent);
    /**
     * 发球
     */
    public void serve();

}
