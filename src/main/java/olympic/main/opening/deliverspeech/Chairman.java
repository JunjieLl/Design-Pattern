package olympic.main.opening.deliverspeech;

import olympic.utils.PrintBlockFormat;
import olympic.main.person.Person;

/**
 * 主席类
 * 主要用于开、闭幕式演讲
 */
public class Chairman extends Person implements Speechable {
    /**
     * 主席构造函数
     * @param name 主席名
     * @param nation 主席国家
     */
    public Chairman(String name, String nation) {
        super(name, nation);
    }

    /**
     * 开/闭幕式发言
     */
    public void deliverSpeech(){
        PrintBlockFormat.getPrintFormat().addString("大家好，我是chairman"+this.getName()+",圣火点燃激情,奥运传递梦想!");
    }

}
