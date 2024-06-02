package UA22.src.main.java.com.example.ua22;

public class Kind extends Person{

    private Paar<Person, Person> eltern;

    public Kind(String name, int alter) {
        super(name);

    }
    public void setEltern(Person mutter, Person vater) {
        this.eltern = new Paar<>(mutter, vater);
    }
    public Paar<Person, Person> getEltern() {
        return this.eltern;
    }
    static boolean geschwister(Kind a, Kind b) {
        return  a.getEltern().getErstes().equals(b.getEltern().getErstes()) &&
                a.getEltern().getZweites().equals(b.getEltern().getZweites());
    }

}
