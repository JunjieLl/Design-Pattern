package olympic.main.person;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athlete.divingathlete.DivingAthlete;
import olympic.main.person.athlete.footballathlete.FootballTeam;
import olympic.main.person.athlete.pingong.PingpongAthlete;
import olympic.main.person.athlete.pingong.PingpongTeam;
import olympic.main.person.athlete.track.TrackAthlete;
import olympic.main.person.athlete.track.TrackTeam;

import java.io.*;
import java.util.*;

/**
 * PersonFactory 作为singleton 生成所有人员
 */
public class PersonFactory {

    private static PersonFactory singleton = new PersonFactory();
    /**
     * PersonFactory是单例的私有构造函数
     */
    private PersonFactory() {
        System.out.println("classname: (PersonFactory) method: (PersonFactory) action: (singleton method模式中生成所有人员) ");
        this.springUtil();
    }

    /**
     * 返回一个工厂单例
     * @return PersonFactory 返回一个工厂单例
     */
    public static PersonFactory getInstance() {
        return singleton;
    }


    private  Properties prop = new Properties();
    private List<String> gamesName;
    private HashMap< String, List<Athlete>> hMap =
            new HashMap< String, List<Athlete>>();

    /**
     * 获得所有比赛名字
     * @return List<String> 比赛名字
     */
    public  List<String> getNames(){
        return gamesName;
    }

    /**
     * 获得运动员列表
     * @param name 运动员名字
     * @return List<Athlete> 运动员列表
     */
    public  List<Athlete> getAthletes(String name){
        return hMap.get(name);
    }

    /**
     * 从配置文件中读取所有参赛人员信息，持久化生成人员
     */
    public  void springUtil(){
        try {

            InputStream in = new BufferedInputStream(new FileInputStream("./src/olympic/main/person/message.properties"));
            this.prop.load(in);     ///加载属性列表
            Iterator<String> it = this.prop.stringPropertyNames().iterator();
//            for(Object key:prop.keySet()){
//                    System.out.print(key+":");
//                    System.out.println(prop.get(key));
//                }

            gamesName= Arrays.asList(((String) this.prop.get("AllGames")).split(","));

            for(String i:gamesName){
                int a=(int)this.prop.get(i+"Athlete.single.number");
                int b=(int)this.prop.get(i+"Athlete.team.number");
                int c=(int)this.prop.get(i+"Athlete.single.member");
                int d=(int)this.prop.get(i+"Athlete.single.per");
                List<Athlete> team=new ArrayList<Athlete>();
                List<Athlete> athleteList=new ArrayList<Athlete>();
                switch (i){
                    case "Relays":
                        for(int j=0;j<b;j++){
                            athleteList.clear();
                            for(int k=0;k<c;k++){
                                athleteList.add(new TrackAthlete("Junjie Zhai"+j,"China"));
                            }
                            team.add(new TrackTeam("美国一队","美国",athleteList));
                        }
                        hMap.put(i,team);
                        break;
                    case "Sprints":
                    case "Marathon":
                        athleteList.clear();
                        for(int j=0;j<a;j++){
                            athleteList.add(new TrackAthlete("Junjie Zhai"+j,"China"));
                        }
                        hMap.put(i,athleteList);
                        break;
                    case "Diving":
                        athleteList.clear();
                        for(int j=0;j<a;j++){
                            athleteList.add(new DivingAthlete("Junjie Zhai"+j,"China"));
                        }
                        hMap.put(i,athleteList);
                        break;
                    case "DivingTeam":
                        for(int j=0;j<b;j++){
                            athleteList.clear();
                            for(int k=0;k<c;k++){
                                athleteList.add(new TrackAthlete("Junjie Zhai"+j,"China"));
                            }
                            team.add(new DivingTeam("美国一队","美国",athleteList));
                        }
                        hMap.put(i,team);
                        break;
                    case "FootballTeam":
                        for(int j=0;j<b;j++){
                            athleteList.clear();
                            for(int k=0;k<c;k++){
                                athleteList.add(new TrackAthlete("Junjie Zhai"+j,"China"));
                            }
                            team.add(new FootballTeam("美国一队","美国",athleteList));
                        }
                        hMap.put(i,team);
                        break;
                    case "Pingpong":
                        athleteList.clear();
                        for(int j=0;j<a;j++){
                            athleteList.add(new TrackAthlete("Junjie Zhai"+j,"China"));
                        }
                        hMap.put(i,athleteList);
                        break;
                    case "PingpongTeam":
                        for(int j=0;j<b;j++){
                            athleteList.clear();
                            for(int k=0;k<c;k++){
                                athleteList.add(new PingpongAthlete("Junjie Zhai"+j,"China"));
                            }
                            team.add(new PingpongTeam("美国一队","美国",athleteList));
                        }
                        hMap.put(i,team);
                        break;

                }
            }

            in.close();

        } catch (Exception e) {
            System.out.println(e);
        }
     }

}
