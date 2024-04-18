package UA22.src.main.java.com.example.ua22;

public class TestSimpsons {

    public static void main(String[] args) {
        Person abe = new Person("Abe", 85);
        Person Mona = new Person("Mona", 80);
        Person Clancy = new Person("Clancy", 82);
        Person Jackie = new Person("Jackie", 70);
        Person Herb = new Person("Herb", 50);
        Person Homer = new Person("Homer", 45);
        Person Marge = new Person("Marge", 40);
        Person Selma = new Person("Selma", 43);
        Person Patty = new Person("Patty", 43);
        Person Bart = new Person("Bart", 12);
        Person Lisa = new Person("Lisa", 10);
        Person Maggie = new Person("Maggie", 3);

        Kind lisaKind = new Kind("Lisa Jr.", 3);
        lisaKind.setEltern(Marge, Homer);
        Kind MaggieKind = new Kind("Maggie Jr.", 3);
        MaggieKind.setEltern(Marge, Homer);
        Kind bartKind = new Kind("Bart Jr.", 3);
        bartKind.setEltern(Marge, Homer);
        Kind MargeKind = new Kind("Marge Jr.", 3);
        MargeKind.setEltern(Jackie, Clancy);
        Kind SelmaKind = new Kind("Selma Jr.", 3);
        SelmaKind.setEltern(Jackie, Clancy);
        Kind jackieKind = new Kind("Jackie Jr.", 3);
        jackieKind.setEltern(Jackie, Clancy);

        boolean sindGeschwister = Kind.geschwister(bartKind, lisaKind);
        System.out.println("Bart und Lisa sind Geschwister: " + sindGeschwister);
        boolean sindGeschwister2 = Kind.geschwister(bartKind, jackieKind);
        System.out.println("Bart und Jackie sind Geschwister: " + sindGeschwister2);

        Paar<Kind, Paar<Person, Person>> familieLisa = family(lisaKind);
        double deltaAlter = dAlter(familieLisa);
        System.out.println("Durchschnittsalter der Eltern bei der Geburt von Lisa: " + deltaAlter);
    }

    static Paar<Kind, Paar<Person, Person>> family(Kind k) {
        Paar<Person, Person> eltern = k.getEltern();
        return new Paar<>(k, eltern);
    }
    static double dAlter(Paar<Kind, Paar<Person, Person>> family) {
        Kind kind = family.getErstes();
        Paar<Person, Person> eltern = family.getZweites();
        double durchschnittsalter = (eltern.getErstes().getAlter() + eltern.getZweites().getAlter()) / 2;
        return durchschnittsalter - kind.getAlter();
    }

}
