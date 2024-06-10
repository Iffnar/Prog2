package UA71;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SchlangeAlsRingpuffer<T> implements Schlange<T> {

    private Ringpuffer<T> elements;

    public SchlangeAlsRingpuffer(int c) {
        elements = new RingpufferFIFO<>(c);
        };

    @Override
    public T front() {
        return elements.get();
    }

    @Override
    public void enqueue(T e) {
        elements.add(e);
    }

    @Override
    public void dequeue() {
        elements.remove();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}

