package olympic.main.person;

import olympic.main.person.athlete.Athlete;

import java.io.*;
import java.util.*;

public class PersonFactory {


    private  Properties prop = new Properties();
    private List<String> gamesName;
    private HashMap< String, List<Athlete>> hMap =
            new HashMap< String, List<Athlete>>();
    public  void springUtil(){
        try {
            //读取属性文件a.properties
//            System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
            InputStream in = new BufferedInputStream(new FileInputStream("./src/olympic/main/person/message.properties"));
            this.prop.load(in);     ///加载属性列表
            Iterator<String> it = this.prop.stringPropertyNames().iterator();
//            for(Object key:prop.keySet()){
//                    System.out.print(key+":");
//                    System.out.println(prop.get(key));
//                }

            gamesName= Arrays.asList(((String) this.prop.get("AllGames")).split(","));
//            System.out.println(gamesName);

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
/
            in.close();

        } catch (Exception e) {
            System.out.println(e);
        }
     }

}
