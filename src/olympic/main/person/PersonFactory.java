package olympic.main.person;

import olympic.main.person.athlete.Athlete;

import java.io.*;
import java.util.*;

/**
 * PersonFactory 作为singleton 生成所有人员
 */
public class PersonFactory {

    private static PersonFactory singleton = new PersonFactory();
    private PersonFactory() {
        System.out.println("classname: (PersonFactory) method: (PersonFactory) action: (singleton method模式中生成所有人员) ");
        this.springUtil();
    }
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
                if(a==0){
                    //这是团队比赛
                }else{
                    //这是单人比赛
                }

            }

            in.close();

        } catch (Exception e) {
            System.out.println(e);
        }
     }

}
