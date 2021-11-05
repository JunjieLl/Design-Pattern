package olympic.scene;

import olympic.main.PreCompetitionSystem.PreCompetitionSystemFacade;
import olympic.main.game.volleyball.round.EliminationRound;
import olympic.main.game.volleyball.round.GroupRound;
import olympic.main.game.volleyball.VolleyballGameManager;

public class VolleyballScene implements Scene {

    @Override
    public void play() {
        System.out.println("classname: (VolleyballScene) method: (play) action: (排球比赛开始) ");
        VolleyballGameManager volleyballGameManager = VolleyballGameManager.getInstance();  // Singleton获取实例
        volleyballGameManager.setTeams(PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade("VolleyballTeam"));
        volleyballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound("四分之一决赛")).setNext(new EliminationRound("半决赛")).setNext(new EliminationRound("决赛"));  // 各轮比赛连接成管道
        volleyballGameManager.start();
        new CeremonyScene(volleyballGameManager.getTopThreeAthletes()).play();
    }
}
