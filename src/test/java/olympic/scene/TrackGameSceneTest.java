package olympic.scene;

import olympic.main.game.track.*;
import olympic.main.person.PersonFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("田径比赛场景")
class TrackGameSceneTest {
    /**
     * 测试DivingGameScene.play()方法
     */
    @Test
    void testPlay() {
        TrackGame[] trackGames = {
                new Relays(PersonFactory.getInstance().getAthletes("Relays")),
                new Marathon(PersonFactory.getInstance().getAthletes("Marathon")),
                new Sprints(PersonFactory.getInstance().getAthletes("Sprints")),
                new Hurdling(PersonFactory.getInstance().getAthletes("Relays")),
                new Breaststroke(PersonFactory.getInstance().getAthletes("Breaststroke")),
                new Freestyle(PersonFactory.getInstance().getAthletes("Freestyle")),
                new Backstroke(PersonFactory.getInstance().getAthletes("Backstroke")),
                new Butterflystroke(PersonFactory.getInstance().getAthletes("Butterflystroke")),
        };
        for (TrackGame t : trackGames) {
            t.start();
        }


    }
}
