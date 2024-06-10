package UA71;

import java.util.Iterator;

public interface Schlange<T> extends Iterable<T> {

    public T front();

    public void enqueue(T e);

    public void dequeue();
}
