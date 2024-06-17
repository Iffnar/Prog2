package UA81;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FolgeAlsDVL<T> implements Folge<T> {
	
	private DVL<T> liste;
	
	public FolgeAlsDVL() {
		liste = new DVL<T>();
	}

	@Override
	public Iterator<T> iterator() {
		return liste.iterator();
	}

	@Override
	public int size() {
		return liste.size();
	}

	@Override
	public boolean isEmpty() {
		return liste.isEmpty();
	}

	@Override
	public boolean contains(T e) {
		return liste.contains(e);
	}

	@Override
	public T get(int pos) throws IndexOutOfBoundsException {
		return liste.get(pos);
	}

	@Override
	public void set(int pos, T e) throws IndexOutOfBoundsException {
		liste.set(pos,  e);
	}

	@Override
	public int pos(T e) throws NoSuchElementException {
		return liste.pos(e);
	}

	@Override
	public void insert(int pos, T e) throws IndexOutOfBoundsException {
		liste.insert(pos,  e);
	}

	@Override
	public void addFirst(T e) {
		liste.addFirst(e);
	}

	@Override
	public void addLast(T e) {
		liste.addLast(e);
	}

	@Override
	public void delete(T e) {
		liste.delete(e);
	}

	@Override
	public void remove(int pos) throws IndexOutOfBoundsException {
		liste.remove(pos);
	}

}
