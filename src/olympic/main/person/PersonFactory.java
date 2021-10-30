package olympic.main.person;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;
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
    private HashMap< String, Athlete> nameMap =
            new HashMap< String, Athlete>();

    /**
     * 获得所有比赛名字
     * @return List<String> 比赛名字
     */
    public  List<String> getNames(){
        return gamesName;
    }

    /**
     * 获得运动员列表
     * @param game 比赛
     * @return List<Athlete> 运动员列表
     */
    public  List<Athlete> getAthletes(String game){
        List<Athlete> a=hMap.get(game);
        return hMap.get(game);
    }

    /**
     * 通过名字获取运动员
     * @param name
     * @return 运动员
     */
    public Athlete getAthleteByName(String name){
        return nameMap.get(name);
    }

    private String getName() {
        Random random = new Random();
        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季"};
        String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
        String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
        int index = random.nextInt(Surname.length - 1);
        String name = Surname[index]; //获得一个随机的姓氏
        int i = random.nextInt(3);//可以根据这个数设置产生的男女比例
        if(i==2){
            int j = random.nextInt(girl.length()-2);
            if (j % 2 == 0) {
                name = "女-" + name + girl.substring(j, j + 2);
            } else {
                name = "女-" + name + girl.substring(j, j + 1);
            }

        }
        else{
            int j = random.nextInt(girl.length()-2);
            if (j % 2 == 0) {
                name = "男-" + name + boy.substring(j, j + 2);
            } else {
                name = "男-" + name + boy.substring(j, j + 1);
            }

        }

        return name;
    }
//    private List<String> getMessage(){
//
//    }

    /**
     * 从配置文件中读取所有参赛人员信息，持久化生成人员
     */
    private void springUtil(){
        //首先 名字工厂
        NameFactory nameFactory=new NameFactory();
        try {

            InputStream in = new BufferedInputStream(new FileInputStream("./src/olympic/main/person/message.properties"));
            this.prop.load(in);     ///加载属性列表
            Iterator<String> it = this.prop.stringPropertyNames().iterator();

            gamesName= Arrays.asList(((String) this.prop.get("AllGames")).split(","));

            for(String i:gamesName){

                String a1=this.prop.get(i+"Athlete.single.number").toString().trim();
                int a=Integer.parseInt(a1.trim());
                int b=Integer.parseInt( this.prop.get(i+"Athlete.team.number").toString().trim());
                int c=Integer.parseInt( this.prop.get(i+"Athlete.team.member").toString().trim());
                int d=Integer.parseInt(this.prop.get(i+"Athlete.per").toString().trim());

                Athlete tempNameAthlete;
                List<Athlete> team=new ArrayList<Athlete>();
                List<Athlete> athleteList=new ArrayList<Athlete>();
                Message message;
                List<Message> messages;

                switch (i){
                    case "Relays":
                        for(int j=0;j<b;j++){
                            athleteList.clear();
                            messages=nameFactory.getMessageList(c);
                            for(int k=0;k<c;k++){
                                tempNameAthlete=new TrackAthlete(messages.get(k).name,messages.get(k).nation);
                                athleteList.add(tempNameAthlete);
                                nameMap.put(messages.get(k).name,tempNameAthlete);
                            }
                            team.add(new TrackTeam(messages.get(0).nation,messages.get(0).nation,athleteList));
                        }
                        hMap.put(i,team);
                        break;
                    case "Sprints":
                    case "Marathon":
                        athleteList.clear();
                        for(int j=0;j<a;j++){
                            message= nameFactory.getMessage();
                            tempNameAthlete=new TrackAthlete(message.name, message.nation);
                            athleteList.add(tempNameAthlete);
                            nameMap.put(message.name,tempNameAthlete);
                        }
                        hMap.put(i,athleteList);
                        break;
                    case "Diving":
                        athleteList.clear();
                        for(int j=0;j<a;j++){
                            message= nameFactory.getMessage();
                            tempNameAthlete=new DivingAthlete(message.name, message.nation);
                            athleteList.add(tempNameAthlete);
                            nameMap.put(message.name,tempNameAthlete);
                        }
                        hMap.put(i,athleteList);
                        break;
                    case "DivingTeam":
                        for(int j=0;j<b;j++){
                            athleteList.clear();
                            messages=nameFactory.getMessageList(c);
                            for(int k=0;k<c;k++){
                                tempNameAthlete=new DivingAthlete(messages.get(k).name,messages.get(k).nation);
                                athleteList.add(tempNameAthlete);
                                nameMap.put(messages.get(k).name,tempNameAthlete);

                            }
                            team.add(new DivingTeam(messages.get(0).nation,messages.get(0).nation,athleteList));
                        }
                        hMap.put(i,team);
                        break;
                    case "FootballTeam":
                        for(int j=0;j<b;j++){
                            athleteList.clear();
                            messages=nameFactory.getMessageList(c);
                            for(int k=0;k<c;k++){
                                tempNameAthlete=new TrackAthlete(messages.get(k).name,messages.get(k).nation);
                                athleteList.add(tempNameAthlete);
                                nameMap.put(messages.get(k).name,tempNameAthlete);

                            }
                            team.add(new FootballTeam(messages.get(0).nation,messages.get(0).nation,athleteList));
                        }
                        hMap.put(i,team);
                        break;
                    case "Pingpong":
                        athleteList.clear();
                        for(int j=0;j<a;j++){
                            message= nameFactory.getMessage();
                            tempNameAthlete=new PingpongAthlete(message.name, message.nation);
                            athleteList.add(tempNameAthlete);
                            nameMap.put(message.name,tempNameAthlete);
                        }
                        hMap.put(i,athleteList);
                        break;
                    case "PingpongTeam":
                        for(int j=0;j<b;j++){
                            athleteList.clear();
                            messages=nameFactory.getMessageList(c);
                            for(int k=0;k<c;k++){
                                tempNameAthlete=new PingpongAthlete(messages.get(k).name,messages.get(k).nation);
                                athleteList.add(tempNameAthlete);
                                nameMap.put(messages.get(k).name,tempNameAthlete);

                            }
                            team.add(new PingpongTeam(messages.get(0).nation,messages.get(0).nation,athleteList));
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
