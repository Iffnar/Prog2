package UA61;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StapelDynArray<T> implements Stapel<T> {

    /*Instanzvariablen */
    private DynArray<T> elements;

    /* Konstruktoren */

    public StapelDynArray () {
        elements = new DynArray<>();
    }

    /*Instanzmethoden */

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

        if ( isEmpty())
            throw new NoSuchElementException();

        return elements.get(elements.size() - 1);
    }
    @Override
    public void push(T e) {
        elements.add(e);
    }
    @Override
    public void pop() {
        elements.remove(elements.size() - 1);

    }
    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
