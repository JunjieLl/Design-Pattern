package olympic.main.game.pingponggame;

import olympic.main.person.athlete.pingong.PingpongAthlete;

import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        System.out.println("请选择是否展示细节，输入true展示细节，输入其他不展示");
        Scanner input=new Scanner(System.in);
        //接受String类型
        Mode.setShowDetail(input.next().equals("true"));

        PingpongAthlete athlete1 = new PingpongAthlete("张继科","中国");
        PingpongAthlete athlete2 = new PingpongAthlete("翟陈浩","中国");

        PingpongGame game = new PingpongGame();

        game.addAthlete(athlete1);
        game.addAthlete(athlete2);

        game.start();

    }

}
