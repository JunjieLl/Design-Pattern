package olympic.main.person;

public abstract class Person {
    protected String name;
    protected String nation;

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
}
