package UA61;

public interface Stapel<T> extends Iterable<T> {

    int size(); // liefert die Anzahl der gespeicherten Elemente

    boolean isEmpty(); // prueft, ob der Stapel kein Element enthaelt

    T top(); // liefert das zuletzt eingefuegte Element des Stapels
    // erzeugt eine NoSuchElementException, falls der Stapel leer ist

    void push(T e); // fuegt das Element e dem Stapel hinzu

    void pop(); // entfernt das oberste Element vom Stapel
    // hat keine Wirkung, falls der Stapel leer ist
}

