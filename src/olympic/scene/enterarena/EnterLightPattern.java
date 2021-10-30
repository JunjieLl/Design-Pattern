package olympic.scene.enterarena;


import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

/***
 * 两支国家队：美国队、中国队；每支队伍两名队员
 * 一支护送奥运圣火队伍：传递者一、二、三
 */

public class EnterLightPattern {
    public static void main(String[] args) {
        PersonFactory personFactory=PersonFactory.getInstance();
        System.out.println(personFactory.getAthleteByNation("中国"));

        List<Athlete> chinaList = PersonFactory.getInstance().getAthleteByNation("中国");
        List<Athlete> mengguList = PersonFactory.getInstance().getAthleteByNation("蒙古");


        Teams allTeam=new Teams("全体国家代表队");

        Teams americaTeam = new Teams("美国队");
        Teams chinaTeam = new Teams("中国队");
        Teams fireTeam=new Teams("圣火队");
        Teams pingpangTeam=new Teams("乒乓球队");

        Person tom = new Person("Tom");
        Person harry = new Person("Harry");
        Person liuXiang = new Person("刘翔");
        Person maLong = new Person("马龙");
        Person zhangJike = new Person("张继科");
        Person p1=new Person("传递者一");
        Person p2=new Person("传递者二");
        Person p3=new Person("传递者三");

        americaTeam.add(tom);
        americaTeam.add(harry);
        chinaTeam.add(liuXiang);
        chinaTeam.add(maLong);
        fireTeam.add(p1);
        fireTeam.add(p2);
        fireTeam.add(p3);
        allTeam.add(americaTeam);
        allTeam.add(chinaTeam);

        pingpangTeam.add(maLong);
        pingpangTeam.add(zhangJike);


        TeamIterator it= (TeamIterator) americaTeam.iterator();
        System.out.println("classname:(TeamPerson) method:(getName) action:(返回人物姓名)");
        System.out.println("*美国队员*");
        while(it.hasNext()){
            TeamPerson person=(TeamPerson) it.next();
            System.out.println(person.getName());

        }
        it= (TeamIterator) chinaTeam.iterator();
        System.out.println("*中国队员*");
        while(it.hasNext()){
            TeamPerson person=(TeamPerson) it.next();
            System.out.println(person.getName());
        }

        it= (TeamIterator) fireTeam.iterator();
        System.out.println("*护送圣火*");
        System.out.println("三位传递者代表入场，并在指定位置等候");
        while(it.hasNext()){
            TeamPerson person=(TeamPerson) it.next();
            System.out.println(person.getName()+person.passFire());
        }
        System.out.println("最后一位传递者点燃圣火");

        it= (TeamIterator)  allTeam.iterator();
        System.out.println("*入场仪式*");
        while(it.hasNext()){
            TeamPerson person=(TeamPerson) it.next();
            System.out.println("现在向我们走来的的是"+person.getName()+"，欢迎运动员们入场。");
        }



    }
}


abstract class TeamPerson {
    public  String name;

    public TeamPerson(String name){
        this.name = name;
    }
    /***
     * 设计模式：迭代器模式
     * 获得队员姓名
     * @return name
     */
    public String getName() {
        return name;
    }

    /***
     * 设计模式：迭代器模式
     * @return 传递使者的动作
     */
    public String passFire(){
        return("向下一名使者传递圣火");
    }


    public abstract void display();
}

class Teams extends TeamPerson implements Aggregate{
    private List<TeamPerson> olympicATeam;

    public Teams(String name){
        super(name);
        olympicATeam = new ArrayList<TeamPerson>();
    }

    /***
     * 模式：组合模式
     * 为队伍添加、删除队员
     * @param person
     */

    public void add(TeamPerson person){
        olympicATeam.add(person);
    }

    public void remove(TeamPerson person){
        olympicATeam.remove(person);
    }

    public void display() {
        for(TeamPerson person : olympicATeam){
            person.display();
        }
    }

    public int getLength() {
        return olympicATeam.size();
    }
    /***
     * 模式：迭代器模式
     * @param index
     * @return 指定位置的队员
     */
    public TeamPerson getPersonAt(int index) {
        return olympicATeam.get(index);
    }

    public TeamIterator iterator() {
        return new PersonIterator(this);
    }

}

class Person extends TeamPerson{
    public Person(String name) {
        super(name);
    }
    public void display() {

        System.out.println("classname:(Person) methods:(display) action:(人物姓名："
        +name+")");
//        System.out.println("这是：" + super.getName());
    }
}


interface Aggregate{
    public abstract TeamIterator iterator();
}

interface TeamIterator{
    /**
     * 设计模式：迭代器模式
     * 检测list中是否还有下一个
     * @return boolean
     */
    public abstract boolean hasNext();

    /**
     * 设计模式：迭代器模式
     * 获取下一个对象
     * @return person
     */
    public abstract Object next();
}

class PersonIterator implements TeamIterator {

    private Teams team;
    private int index;

    public PersonIterator(Teams team) {
        this.team = team;
        this.index = 0;
    }

    public boolean hasNext() {
        if (index < team.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    public Object next() {
        TeamPerson person = team.getPersonAt(index);
        index++;
        return person;
    }
}




