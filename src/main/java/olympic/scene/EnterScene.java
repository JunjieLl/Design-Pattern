package olympic.scene;

import olympic.Utils.PrintBlockFormat;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.opening.enterarena.EnterIterator;
import olympic.main.opening.enterarena.EnterManager;

import java.util.Random;

public class EnterScene implements Scene {

    /**
     * 国家队入场仪式
     */
    @Override
    public void play() {
        EnterManager enterManager = EnterManager.getInstance();
        TeamAthlete torchBarer = new TeamAthlete("火炬传递队");

        String[] country = PersonFactory.getInstance().getNations().toArray(new String[0]);



        for(int i=0;i<10;i++)
        {

            int ran= new Random().nextInt(country.length);

            TeamAthlete tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[ran]), country[ran]);
            if (tempList.getNumber() > 0) {
                enterManager.setTeams(tempList);
                torchBarer.addMember(tempList.getFirstAthlete());
            }

        }


        PrintBlockFormat.getPrintFormat().addString("入场仪式");
        EnterIterator et = enterManager.iterator();
        while (et.hasNext()) {
            TeamAthlete myList = et.next();
            PrintBlockFormat.getPrintFormat().addString("现在向我们走来的是" + myList.getNation() + "队，让我们欢迎他们！");
        }
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);
        System.out.println('\n');
        System.out.println("classname: (IndividualAthlete) method: (passFire) action: (迭代器模式 传递圣火)");
        PrintBlockFormat.getPrintFormat().addString("圣火传递");
        torchBarer.passFire();
        PrintBlockFormat.getPrintFormat().addString("最后一位使者点燃了奥运圣火！");
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);
    }

    public static void main(String[] args) {
        EnterScene enterScene=new EnterScene();
        enterScene.play();
    }
}
