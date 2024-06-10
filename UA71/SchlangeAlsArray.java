package UA71;

import UA61.DynArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SchlangeAlsArray<T> implements Schlange<T>{


    private DynArray<T> elements;

    public SchlangeAlsArray() {
        elements = new DynArray<T>();
    }

    @Override
    public T front() {
        if(elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.get(0);
    }

    @Override
    public void enqueue(T e) {
        elements.set(0, e);
    }

    @Override
    public void dequeue() {
        elements.remove(0);
    }

    @Override
    public Iterator iterator() {
        return elements.iterator();
    }
}
