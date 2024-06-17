package UA93;

public class Rechteck implements Comparable<Rechteck> {

    private int length;
    private int width;

    public Rechteck(int length, int width) {
        this.width = width;
        this.length = length;
    }

    public int flaeche() {
        return width * length;
    }
    public int umfang() {
        return 2*(length + width);
    }

    @Override
    public int compareTo(Rechteck o) {
        return this.flaeche() - o.flaeche();    }

    public int UmfangComparator(Rechteck o) {
        return this.umfang() - o.umfang();    }
}
