package UA73;

import UA71.Ringpuffer;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RingpufferLIFO<T> extends Ringpuffer<T> {

    private T[] arr;
    private int p;
    private int q;

    @SuppressWarnings("unchecked")
    public RingpufferLIFO(int capacity) throws IllegalArgumentException {
        super(capacity);
        this.arr = (T[]) new  Object[capacity];
        p = 0;
        q = 0;
    }

    @Override
    public T get() throws NoSuchElementException {

        if(size() == 0) {
            throw new NoSuchElementException();
        }
        return arr[p+size-1];
    }

    // überschreibt den ältesten Beitrag
    @Override
    public void add(T e) throws IllegalStateException {
        if(size == capacity) {
            arr[p] = e;
        } else {
            int pos = (p + size) % capacity;
            arr[pos] = e;
            size++;
        }
    }

    @Override
    public void remove() {
        if (size > 0) {
            p = (p+1) % capacity;
            size--;
        }
    }
    class LIFORPIterator implements Iterator<T> {
        // liefert die Eintraege in der Reihenfolge
        //   jüngster, zweitjüngster, ...
        int i = 0;

        @Override
        public boolean hasNext() {
            return (i < size);
        }

        @Override
        public T next() {
            return arr[(p - i++) % capacity];
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new LIFORPIterator();
    }
}
