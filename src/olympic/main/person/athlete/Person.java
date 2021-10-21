package olympic.main.person.athlete;

public abstract class Person {
    protected String name;
    protected String gender;

    protected Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}
