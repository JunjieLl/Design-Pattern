package olympic.scene.enterarena;

import olympic.main.game.Game;
import olympic.main.game.Iterator;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

import java.util.List;

public class EnterIterator implements Iterator {
    private EnterManager list;
    private int index;
    public EnterIterator(EnterManager list) {
        this.list = list;
        this.index = 0;
    }
    @Override
    public boolean hasNext() {
        if (this.index < list.getLength()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public TeamAthlete next() {
        TeamAthlete allList = list.getTeamAt(this.index);
        this.index++;
        return allList;
    }

}
