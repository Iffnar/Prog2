package UA51;

import UA22.src.main.java.com.example.ua22.Person;

import java.util.Iterator;

public class Testklasse {

    public static void main(String[] args) {

        Person anna = new Person("Anna");
        Person ben = new Person("ben");
        Person chris = new Person("chris");
        Person didi = new Person("didi");

        Person[] personen = new Person[] {null, anna, ben, chris, didi};

        Iterator<Person> it = new PostbotenIterator<>(personen);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
