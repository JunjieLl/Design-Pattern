package olympic.main.person;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.divingathlete.DivingAthlete;
import olympic.main.person.athlete.divingathlete.DivingTeam;
import olympic.main.person.athlete.footballathlete.FootballTeam;
import olympic.main.person.athlete.pingong.PingpongAthlete;
import olympic.main.person.athlete.pingong.PingpongTeam;
import olympic.main.person.athlete.track.TrackAthlete;
import olympic.main.person.athlete.track.TrackTeam;

import java.io.*;
import java.util.*;

/**
 * PersonFactory 作为singleton 生成所有人员
 *  Prototype 备份read Only 的list
 */
public class PersonFactory {
    /**
     * PersonFactory 实例
     */
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


    /**
     * 所有比赛的名字
     */
    private List<String> gamesName;
    /**
     * 所有国家的名字,不能重复
     */
    private List<String> nations=new ArrayList<>();
    /**
     * 比赛和人员的映射表
     */
    private HashMap< String, List<Athlete>> hMap =
            new HashMap<>();
    /**
     * 名字和人员的映射表
     */
    private HashMap< String, Athlete> nameMap =
            new HashMap< >();
    /**
     * 国家和人员的映射表
     */
    private HashMap< String, List<Athlete>> nationMap =
            new HashMap<>();

    /**
     * 获得所有比赛名字
     * @return List<String> 比赛名字
     */
    public  List<String> getNames(){
        return gamesName;
    }

    /**
     * 获得所有比赛名字
     * @return List<String> 比赛名字
     */
    public  List<String> getNations(){
        return nations;
    }

    /**
     * 获得运动员列表
     * @param game 比赛
     * @return List<Athlete> 运动员列表
     */
    public  List<Athlete> getAthletes(String game){
        return hMap.get(game);
    }

    /**
     * 通过名字获取运动员
     * @param name 运动员名字
     * @return 运动员
     */
    public Athlete getAthleteByName(String name){
        return nameMap.get(name);
    }

    /**
     * 通过国家获取运动员
     * @param nation 国家
     * @return 运动员列表
     */
    public List<Athlete> getAthleteByNation(String nation){
        return nationMap.get(nation);
    }

    /**
     * 把运动员和国籍做一个映射
     * @param nation 国家
     * @param athlete 名字
     */
    private void addNationMap(String nation,Athlete athlete){
        if(!nations.contains(nation))nations.add(nation);
        if(nationMap.containsKey(nation)){
            nationMap.get(nation).add(athlete);
        }else{
            List<Athlete> list=new ArrayList<>();
            list.add(athlete);
            nationMap.put(nation,list);
        }
    }



    /**
     * 从配置文件中读取所有参赛人员信息，持久化生成人员
     */
    public void springUtil(){
        //首先 名字工厂
        NameFactory nameFactory=new NameFactory();
        try {
            Properties prop = new Properties();
            InputStream in = new BufferedInputStream(new FileInputStream("./src/olympic/main/person/message.properties"));
            prop.load(in);     ///加载属性列表

            gamesName= Arrays.asList(((String)prop.get("AllGames")).split(","));

            for(String i:gamesName){

                String a1=prop.get(i+"Athlete.single.number").toString().trim();
                int a=Integer.parseInt(a1.trim());
                int b=Integer.parseInt( prop.get(i+"Athlete.team.number").toString().trim());
                int c=Integer.parseInt( prop.get(i+"Athlete.team.member").toString().trim());

                Athlete tempNameAthlete;
                List<Athlete> team=new ArrayList<>();
                List<Athlete> athleteList;
                Message message;
                List<Message> messages;

                switch (i){
                    case "Relays":
                        for(int j=0;j<b;j++){
                            athleteList=new ArrayList<>();
                            messages=nameFactory.getMessageList(c);
                            for(int k=0;k<c;k++){
                                tempNameAthlete=new TrackAthlete(messages.get(k).name,messages.get(k).nation);
                                athleteList.add(tempNameAthlete);
                                nameMap.put(messages.get(k).name,tempNameAthlete);
                                addNationMap(messages.get(k).nation,tempNameAthlete);
                            }
                            team.add(new TrackTeam(messages.get(c).name,messages.get(0).nation,athleteList));
                        }
                        hMap.put(i,team);
                        break;
                    case "Sprints":
                    case "Hurdling":
                    case "Marathon":
                        athleteList=new ArrayList<>();
                        for(int j=0;j<a;j++){
                            message= nameFactory.getMessage();
                            tempNameAthlete=new TrackAthlete(message.name, message.nation);
                            athleteList.add(tempNameAthlete);
                            nameMap.put(message.name,tempNameAthlete);
                            addNationMap(message.nation,tempNameAthlete);
                        }
                        hMap.put(i,athleteList);
                        break;
                    case "Diving":
                        athleteList=new ArrayList<>();
                        for(int j=0;j<a;j++){
                            message= nameFactory.getMessage();
                            tempNameAthlete=new DivingAthlete(message.name, message.nation);
                            athleteList.add(tempNameAthlete);
                            nameMap.put(message.name,tempNameAthlete);
                            addNationMap(message.nation,tempNameAthlete);
                        }
                        hMap.put(i,athleteList);
                        break;
                    case "DivingTeam":
                        for(int j=0;j<b;j++){
                            athleteList=new ArrayList<>();
                            messages=nameFactory.getMessageList(c);
                            for(int k=0;k<c;k++){
                                tempNameAthlete=new DivingAthlete(messages.get(k).name,messages.get(k).nation);
                                athleteList.add(tempNameAthlete);
                                nameMap.put(messages.get(k).name,tempNameAthlete);
                                addNationMap(messages.get(k).nation,tempNameAthlete);

                            }
                            team.add(new DivingTeam(messages.get(c).name,messages.get(0).nation,athleteList));
                        }
                        hMap.put(i,team);
                        break;
                    case "FootballTeam":
                        for(int j=0;j<b;j++){
                            athleteList=new ArrayList<>();
                            messages=nameFactory.getMessageList(c);
                            for(int k=0;k<c;k++){
                                tempNameAthlete=new TrackAthlete(messages.get(k).name,messages.get(k).nation);
                                athleteList.add(tempNameAthlete);
                                nameMap.put(messages.get(k).name,tempNameAthlete);
                                addNationMap(messages.get(k).nation,tempNameAthlete);

                            }
                            team.add(new FootballTeam(messages.get(c).name,messages.get(0).nation,athleteList));
                        }
                        hMap.put(i,team);
                        break;
                    case "Pingpong":
                        athleteList=new ArrayList<>();
                        for(int j=0;j<a;j++){
                            message= nameFactory.getMessage();
                            tempNameAthlete=new PingpongAthlete(message.name, message.nation);
                            athleteList.add(tempNameAthlete);
                            nameMap.put(message.name,tempNameAthlete);
                            addNationMap(message.nation,tempNameAthlete);
                        }
                        hMap.put(i,athleteList);
                        break;
                    case "PingpongTeam":
                        for(int j=0;j<b;j++){
                            athleteList=new ArrayList<>();
                            messages=nameFactory.getMessageList(c);
                            for(int k=0;k<c;k++){
                                tempNameAthlete=new PingpongAthlete(messages.get(k).name,messages.get(k).nation);
                                athleteList.add(tempNameAthlete);
                                nameMap.put(messages.get(k).name,tempNameAthlete);
                                addNationMap(messages.get(k).nation,tempNameAthlete);

                            }
                            team.add(new PingpongTeam(messages.get(c).name,messages.get(0).nation,athleteList));
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
