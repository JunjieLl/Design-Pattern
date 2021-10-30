package olympic.scene;

import olympic.main.postgame.review_qualification.ReviewMediatorConcrete;
import olympic.scene.Scene;

/**
 * 检查比赛资质（Qualification）的场景.
 */
public class ReviewQScene implements Scene {

    @Override
    public void play() {
        new ReviewMediatorConcrete();
    }
}
