package Prog2;

public class Paar<E, Z> {

    private E erstes;
    private Z zweites;

    public Paar(E erstes, Z zweites) {
        this.erstes = erstes;
        this.zweites = zweites;
    }

    public E getErstes() {
        return erstes;
    }

    public Z getZweites() {
        return zweites;
    }
    void setErstes(E erstes) {
        this.erstes = erstes;
    }
    void setZweites(Z zweites) {
        this.zweites = zweites;
    }
    @Override
    public String toString() {
        return "com.example.ua21.Paar{erstes: " + this.erstes + "zweites: " + this.zweites + "}";
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Paar<?, ?>)) {
            return false;
        };
        Paar<E, Z> p = (Paar<E, Z>) obj;
        return this.getErstes().equals(p.getErstes()) && this.getZweites().equals(p.getErstes());
    }

}
