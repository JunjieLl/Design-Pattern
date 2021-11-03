package olympic.main.person;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    protected String name;
    protected String nation;
    protected List<String> memory = new ArrayList<>();

    protected Person(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public List<String> getMemory() {
        return memory;
    }

    /**
     * 需要雨标记接口配合使用
     */
    public void deliverSpeech() {
        throw new UnsupportedOperationException();
    }
}
