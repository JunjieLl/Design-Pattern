package olympic.main.game.shoot;


import olympic.main.game.Game;
import olympic.main.person.Athlete;
import olympic.main.person.athlete.IndividualAthlete;

/**
 * 设计模式：装饰器模式
 */
class IndividualShootAthlete implements Athlete {
    private IndividualAthlete individualAthlete = new IndividualAthlete("李俊杰","男");

    @Override
    public void participate(Game game) {
        System.out.println("classname: (IndividualShootAthlete) method: (participate) action: (装饰器模式中个人运射击动员参与比赛) ");
        individualAthlete.participate(game);
    }
}