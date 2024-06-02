package UA52;

import java.util.Iterator;

public class testsnake {

    public static void main(String[] args) {
        Integer[][] arr2D = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};



        Iterator<Integer> it = new SnakeIterator2DArray<>(arr2D);

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}