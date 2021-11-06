package olympic.main.person;

/**
 * 用来传递运动员信息的类
 */
public class Message {
    /**
     * Message 的有参构造函数
     *
     * @param name   运动员名字
     * @param nation 国家
     */
    public Message(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    /**
     * 无参构造函数
     */
    public Message() {
    }

    /**
     * 姓名
     */
    public String name;
    /**
     * 国家
     */
    public String nation;
}
