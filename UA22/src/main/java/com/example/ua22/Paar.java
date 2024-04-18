package UA22.src.main.java.com.example.ua22;

public class Paar<E, Z> {
    private E erstes;
    private Z zweites;

    public E getErstes() {
        return erstes;
    }

    public Z getZweites() {
        return zweites;
    }

    public void setZweites(Z zweites) {
        this.zweites = zweites;
    }

    public void setErstes(E erstes) {
        this.erstes = erstes;
    }

    public Paar(E erstes, Z zweites) {
        this.erstes = erstes;
        this.zweites = zweites;
    }


}
