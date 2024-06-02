package UA22.src.main.java.com.example.ua22;

public class Person {

    private String name;
    private int alter;
    public Person(String name) {
        this.name = name;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    @Override
    public String toString() {
        return name;
    }
}
