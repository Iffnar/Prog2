package UA22.src.main.java.com.example.ua22;

public class TestSimpsons {

    public static void main(String[] args) {
        Person abe = new Person("Abe");
        Person Mona = new Person("Mona");
        Person Clancy = new Person("Clancy");
        Person Jackie = new Person("Jackie");
        Person Herb = new Person("Herb");
        Person Homer = new Person("Homer");
        Person Marge = new Person("Marge");
        Person Selma = new Person("Selma");
        Person Patty = new Person("Patty");
        Person Bart = new Person("Bart");
        Person Lisa = new Person("Lisa");
        Person Maggie = new Person("Maggie");

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
