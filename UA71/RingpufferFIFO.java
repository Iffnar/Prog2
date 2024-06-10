package UA71;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RingpufferFIFO<T> extends Ringpuffer<T> {

    private  T[] arr;
    private int p; // pos des aeltesten Eintrags

    // Konstruktor ///////////////////////////////

    @SuppressWarnings("unchecked")
    public RingpufferFIFO(int c) {
        super(c);
        this.arr = (T[]) new  Object[c];
        p = 0;
    }

    // innere Klasse ////////////////////////////

    class RPIterator implements Iterator<T> {
        // liefert die Eintraege in der Reihenfolge
        //   aeltester, zweitaeltester, ...
        int i = 0;

        @Override
        public boolean hasNext() {
            return (i < size);
        }

        @Override
        public T next() {
            return arr[(p + i++) % capacity];
        }
    }

    // Methoden /////////////////////////////////////

    @Override
    public Iterator<T> iterator() {
        return new RPIterator();
    }

    @Override
    public T get() throws NoSuchElementException {
        // liefert den aeltesten Eintrag
        if(size() == 0)
            throw new NoSuchElementException();
        return arr[p];
    }

    @Override
    public void add(T e) throws IllegalStateException {
        // Exception bei vollem Puffer
        if (size >= capacity)
            throw new IllegalStateException("Puffer voll");

        // "hinten" anhaengen
        int pos = (p + size) % capacity;
        arr[pos] = e;
        size++;
    }

    public void remove() {
        // entfernt den aeltesten Eintrag
        if (size > 0) {
            p = (p+1) % capacity;
            size--;
        }
    }

    public void showArr() {
        String s = "";
        for (int i = 0; i < arr.length; i++)
            s = s + " " + arr[i];
        s = s+ "\tp: " + p + "\tsize: " + size;
        System.out.println(s);
    }
}
