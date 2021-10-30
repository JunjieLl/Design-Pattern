package olympic.main.person;

import java.util.ArrayList;

public abstract class Person {
    protected String name;
    protected String nation;
    protected ArrayList<String> memory = new ArrayList<>();

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

    public String getName() {
        return this.name;
    }
}
