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

    /**
     * 设计模式：工厂函数
     * @param name 运动员姓名
     * @param gender 运动员性别
     * @return 运动员
     */
    public static Athlete AthleteFactory(String name, String gender) {
        return new IndividualAthlete(name, gender);
    }

}



