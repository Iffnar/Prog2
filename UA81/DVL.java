package UA81;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DVL<T> implements Iterable<T> {
	
	private int size;
	private ListenElem first;
	private ListenElem last;
	
	// innere Klasse ////////////////////////////////
	private class ListenElem {
		T value;
		ListenElem prev;
		ListenElem next;
		
		ListenElem(T v){
			this.value = v;
			this.prev = null;
			this.next = null;
		}
	}
	
	// innere Klasse /////////////////////////////////////////
	class DVLIterator implements Iterator<T>{
		ListenElem crs = first;
		
		public boolean hasNext() {
			return crs != null;
		}
		
		public T next() {
			T v = crs.value;
			crs = crs.next;
			return v;
		}
	}
	/////////////////////////////////////////////////////
	
	// Konstruktor
	public DVL() {
		this.size = 0;
		this.first = null;
		this.last = null;
	}
	
	/////////////////////////////////////////////////

	@Override
	public Iterator<T> iterator() {
		return new DVLIterator();
	}


	public int size() {
		return this.size;
	}


	public boolean isEmpty() {
		return (size == 0);
	}


	public boolean contains(T e) {
		for(T v: this)
			if (v.equals(e))
				return true;
		return false;
	}
	
	
	public T get(int pos) throws IndexOutOfBoundsException {
		ListenElem csr = elemPos(pos);
		return csr.value;
	}

	
	public void set(int pos, T e) throws IndexOutOfBoundsException {
		ListenElem csr = elemPos(pos);
		csr.value = e;
	}
	
	
	public int pos(T e) throws NoSuchElementException {
		// liefert Position des Elementes e
		if(this.isEmpty())
			throw new NoSuchElementException("leere Folge");
		// else: Liste durchlaufen bis zum Ende oder bis e gefunden
		ListenElem csr = first;
		int pos = 0;
		while(csr!= null && !csr.value.equals(e)) {
			csr = csr.next;
			pos++;
		}
		if (csr == null)
			throw new NoSuchElementException("Element nicht gefunden");
		// else: e gefunden
		return pos;
	}
	
	
	public void insert(int pos, T e) throws IndexOutOfBoundsException {
		//  pos == size bei insert erlaubt
		if (!check(pos) && pos > size)
			throw new IndexOutOfBoundsException();
		
		ListenElem neu = new ListenElem(e);
		
		// Sonderfall pos == 0:
		if (pos == 0) {
			addFirst(e);
			return;
		}
		
		//Sonderfall pos == size != 0
		if (pos == size) {
			addLast(e);
			return;
		}
			
		// Normalfall: einfuegen "mittig"
		ListenElem csr = elemPos(pos);
		neu.next = csr;
		neu.prev = csr.prev;
		csr.prev.next = neu;
		csr.prev = neu;
		size++;
	}
	


	public void addFirst(T e) {
		ListenElem neu = new ListenElem(e);
		if (isEmpty()) {
			// Sonderfall: Liste vorher leer
			last = neu;
		}
		else {
			first.prev = neu;
		}	
		first = neu;
		size++;
	}
	



	public void addLast(T e) {
		ListenElem neu = new ListenElem(e);
		if (!isEmpty()) {
			last.next = neu;
			neu.prev = last;
		}
		else {
			// Sonderfall: Liste vorher leer
			first = neu;
		}
		last = neu;
		size++;
	}
	
	
	

	public void remove(int pos) throws IndexOutOfBoundsException {
		ListenElem csr = elemPos(pos); // wirft ggf IOOBE
		// e gefunden: 4 Fälle 
		if (csr == first) {
			if (csr == last) {
				// e ist einziges Element
				first = null;
				last = null;
			}
			else {
				// e ist erstes Element
				first.next.prev = null;
				first = first.next;
			}
		}
		else {
			if (csr == last) {
				// e ist letztes Element
				csr.prev.next = null;
				last = last.prev;
			}
			else {
				// e ist "mittleres" Element
				csr.prev.next = csr.next;
				csr.next.prev = csr.prev;
			}
		}
		size--;
	}
	

	public void delete(T e) {
		// entfernt das Element mit Eintrag e
		// keine Wirkung, falls !contains(e)
		int pos;
		try {
			pos = pos(e);
		} 
		catch (NoSuchElementException ex) {
			return;
		}
		remove(pos);
	}

	
	// private Hilfsmethoden /////////////////
	
	private boolean check(int pos) {
		// prueft, ob pos eine gueltige Position darstellt
		return (pos >= 0 && pos < size);
	}
	
	
	
	private ListenElem elemPos(int pos) throws IndexOutOfBoundsException {
		// liefert eine Referenz auf das Element an Position pos
		if (!check(pos))
			throw new IndexOutOfBoundsException();
		ListenElem csr = first;
		for (int i = 0; i < pos; i++)
			csr = csr.next;
		return csr;
	}

}
