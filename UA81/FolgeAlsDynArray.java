package UA81;

import UA61.DynArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FolgeAlsDynArray<T> implements Folge<T>  {

    private DynArray<T> arr;

    public FolgeAlsDynArray() {
        arr = new DynArray<>();
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public boolean contains(T e) {
        for (T t: arr) {
            if(t.equals(e)) {
                return true;
            }
        };
        return false;
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        if(pos < 0 || pos >= arr.size()) throw new IndexOutOfBoundsException();
        return arr.get(pos);
    }

    @Override
    public void set(int pos, T e) throws IndexOutOfBoundsException {
        if(pos < 0 || pos >= arr.size()) throw new IndexOutOfBoundsException();
        arr.set(pos, e);
    }

    @Override
    public int pos(T e) throws NoSuchElementException {
        if(!arr.contains(e)) {
            throw new NoSuchElementException();
        }
        int index = 0;
        for(T t: arr) {
            if(t.equals(e)) {
                return index;
            }
            index++;
        }
        return -1;
    };

    @Override
    public void insert(int pos, T e) throws IndexOutOfBoundsException {
        if(pos < 0 || pos >= arr.size()) throw new IndexOutOfBoundsException();
        if(pos == arr.size()) {
            addLast(e);
            return;
        }
        DynArray<T> tmp = new DynArray<>();
        for(int i = 0; i < pos; i++) {
            tmp.add(arr.get(i));
        }
        tmp.add(e);
        for(int i = pos; i < arr.size(); i++) {
            tmp.add(arr.get(i));
        }
        arr = tmp;

    }

    @Override
    public void addFirst(T e) {
        insert(0, e);
    }

    @Override
    public void addLast(T e) {
        arr.add(e);
    }

    @Override
    public void remove(int pos) throws IndexOutOfBoundsException {
        if(pos < 0 || pos >= arr.size()) throw new IndexOutOfBoundsException();

        arr.remove(pos);
    }

    @Override
    public void delete(T e) {
        arr.delete(e);
    }

    @Override
    public Iterator<T> iterator() {
        return new FolgeAlsDynArrayIterator();
    }

    class FolgeAlsDynArrayIterator implements Iterator<T> {
       private int index = 0;
        @Override
        public boolean hasNext() {
            return index < arr.size();
        }

        @Override
        public T next() {
            return arr.get(index++);
        }
    }
}
