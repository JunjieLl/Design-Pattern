package olympic.scene;

import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.pingong.PingpongAthlete;
import olympic.main.postgame.review_qualification.ReviewMediatorConcrete;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

/**
 * 测试赛后检查资质场景
 */
@DisplayName("赛后检查资质测试")
public class ReviewQSceneTest {

    @Test
    void testReviewQuality() {
        Athlete badAthlete = new PingpongAthlete("Bad Person", "Bad Game");
        new ReviewMediatorConcrete(badAthlete, "Trouble Game");
    }

}
