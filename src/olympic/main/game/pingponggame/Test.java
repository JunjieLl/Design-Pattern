package olympic.main.game.pingponggame;

import olympic.main.person.athlete.pingong.PingpongAthlete;

import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        System.out.println("请选择是否展示细节，输入true/false");
        Scanner input=new Scanner(System.in);
        //接受String类型
        Mode.setShowDetail(input.next()=="true");

        PingpongAthlete athlete1 = new PingpongAthlete("张继科","中国",60);
        PingpongAthlete athlete2 = new PingpongAthlete("翟陈浩","中国",70);

//        PingpongCoach coach1 = new PingpongCoach("张继科的教练","");
//        PingpongCoach coach2 = new PingpongCoach("翟陈浩的教练","");

//        coach1.coach(athlete1);
//        coach2.coach(athlete2);

//        coach1.giveStrategy("defend");
//        coach2.giveStrategy("offense");

//        PingpongGameRound game = new PingpongGameRound();

        PingpongGame game = new PingpongGame();

        game.addAthlete(athlete1);
        game.addAthlete(athlete2);

        game.start();

    }

}
