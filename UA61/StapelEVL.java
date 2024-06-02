package UA61;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StapelEVL<T> implements Stapel<T> {

    private EVL<T> elements;

    public StapelEVL() {
        elements = new EVL<>();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public T top() {
        if(isEmpty()) throw new NoSuchElementException();
        return elements.getFirst();
    }

    @Override
    public void push(T e) {
        elements.insert(e);
    }

    @Override
    public void pop() {
        elements.removeFirst();
    }

    @Override
    public Iterator iterator() {
        return elements.iterator();
    }
}
