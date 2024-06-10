package UA71;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Ringpuffer<T> implements Iterable<T>{

    protected int capacity; // Groesse des Arrays (fix)
    protected int size; // Anzahl der aktuell gepufferten Elemente

    // Konstruktor /////////////////

    public Ringpuffer(int capacity) throws IllegalArgumentException {
        if (capacity <= 0)
            throw new IllegalArgumentException("Negative capacity");
        this.capacity = capacity;
        this.size = 0;
    }

    // Methoden ////////////////////////

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int capacity() {
        return capacity;
    }

    public boolean contains(T e) {
        for(T t: this)
            if (t.equals(e))
                return true;
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for(T t: this) {
            s = s + t + " ";
        }
        return s;
    }

    public abstract T get() throws NoSuchElementException;

    public abstract void add(T e) throws IllegalStateException;

    public abstract void remove();

    public abstract Iterator<T> iterator();
}
