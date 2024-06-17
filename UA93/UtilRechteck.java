package UA93;

import UA81.Folge;

import java.util.Comparator;

public class UtilRechteck {

    public static Rechteck min(Folge<Rechteck> r, Comparator<Rechteck> comp) {

        Rechteck minRechteck = null;
        for(Rechteck s: r) {
            if(minRechteck == null || comp.compare(s, minRechteck) < 0) {
                minRechteck = s;
            }
        }
        return minRechteck;
    }
}
