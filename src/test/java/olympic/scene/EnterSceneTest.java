package olympic.scene;

import olympic.main.director.Sleep;
import olympic.main.opening.enterarena.EnterIterator;
import olympic.main.opening.enterarena.EnterManager;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.TeamAthlete;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

@DisplayName("入场仪式场景")
class EnterSceneTest {
    /**
     * 测试EnterScene.play()方法
     */

    @Test
    void testPlay() {
        Sleep.setNeedSleep(false);
        EnterManager enterManager = EnterManager.getInstance();
        TeamAthlete torchBarer = new TeamAthlete("火炬传递队");

        String[] country;
        country = PersonFactory.getInstance().getNations().toArray(new String[0]);


        for (int i = 0; i < 10; i++) {
//            int ran= 0+(int)(Math.random()*(country.length-1+1));
            int ran = new Random().nextInt(country.length);

            TeamAthlete tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[ran]), country[ran]);
            if (tempList.getNumber() > 0) {
                enterManager.setTeams(tempList);
                torchBarer.addMember(tempList.getFirstAthlete());
            }

        }

        EnterScene enterScene = new EnterScene();
        enterScene.play();

    }
}
