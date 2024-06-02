package UA51;

import java.util.Iterator;

public class PostbotenIterator<T> implements Iterator<T> {

    private T[] elements;
    private int i;

    public PostbotenIterator(T[] elements) {
        this.elements = elements;
        i = 1;
    }

    @Override
    public boolean hasNext() {
        return i > 0;
    }
    @Override
    public T next() {
        T element = elements[i];
        if ( (i % 2) != 0) {
            i += 2;
            if(i >= elements.length) {
                i = elements.length - (elements.length % 2 == 0 ? 2 : 1);
            }
        } else {
            i -= 2;
        }
        return element;

    }
}
