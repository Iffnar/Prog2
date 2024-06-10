package UA71;

import UA61.EVL;

import java.util.Iterator;

public class SchlangeAlsEVL<T> implements Schlange<T> {

    private EVL<T> elements;

    public SchlangeAlsEVL() {
        elements = new EVL<T>();
    }

    @Override
    public T front() {
        return elements.getFirst();
    }

    @Override
    public void enqueue(T e) {
        elements.insert(e);
    }

    @Override
    public void dequeue() {
        elements.removeFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
