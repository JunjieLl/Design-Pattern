package olympic.main.person;

import java.util.ArrayList;

public abstract class Person {
    protected String name;
    protected String gender;
    protected ArrayList<String> memory = new ArrayList<>();

    protected Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }
}
