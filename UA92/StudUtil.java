package UA92;
import UA91.Stud;

public class StudUtil {

    public static Stud[] sort(Menge<Stud> m) {
        Stud[] sortedStud = new Stud[m.size()];
        Stud temp = m.get();
        sortedStud[0] = temp;
        m.delete(temp);

        for(Stud s: m) {
            for(int i = sortedStud.length -1; i >= 0; i--) {
                if (sortedStud[i] != null && s.compareTo(sortedStud[i]) < 0) {
                    sortedStud[i +1] = sortedStud[i];
                    sortedStud[i] = s;


                } else if(sortedStud[i] != null && s.compareTo(sortedStud[i]) > 0) {
                    sortedStud[i +1] = s;

                }
            }
        }
        return sortedStud;
    }
    public static void main(String[] args) {
        Stud a = new Stud("Anna");
        Stud b = new Stud("Benjamin");
        Stud c = new Stud("Carlos");
        Stud d = new Stud("Dora");

        Menge <Stud> m = new MengeDynArray<Stud>();
        m.insert(a);
        m.insert(a);
        m.insert(b);
        m.insert(c);

        Stud[] arr = sort(m);

        for(Stud s : arr) {
            System.out.println(s);
        }

    }
}
