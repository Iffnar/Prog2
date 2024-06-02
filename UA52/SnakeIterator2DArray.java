package UA52;

import java.util.Iterator;

public class SnakeIterator2DArray<T> implements Iterator<T> {

    private int row, col; //Zeilen- und Spaltenindikator
    T[][] array;

    public SnakeIterator2DArray(T[][] array) {
        this.array = array;
        row = 0;
        col = 0;
    }
    @Override
    public boolean hasNext() {
        return row < array.length && (array.length % 2 == 1 ? col < array[row].length : col > 0);
    }

    @Override
    public T next() {
        T element = array[row][col];

        if(row % 2 == 0) {
           if(col < array[row].length -1) {
               col++;
           } else {
               row++;
           }
        }
        else {
            if(col > 0) {
                col--;
            } else {
                row++;
            }
        }
        return element;
    }
}
