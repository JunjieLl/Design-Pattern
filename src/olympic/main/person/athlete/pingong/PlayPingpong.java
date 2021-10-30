package olympic.main.person.athlete.pingong;

import olympic.main.person.athlete.Athlete;

import java.security.PublicKey;

public interface PlayPingpong {
    public Boolean playWith(Athlete oppoent);
    /**
     * 发球
     */
    public void serve();

    public Integer getCapacity();

}
