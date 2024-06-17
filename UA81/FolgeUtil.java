package UA81;

public class FolgeUtil {

    static <T> int frequency(Folge<T> f, T v) {
        int counter = 0;
        for (T e : f) {
            if(e.equals(v)) {
                counter++;
            }
        }
        return counter;
    }

    static <T> void swap(Folge<T> f, int i, int j) {
        T tmp = f.get(i);
        f.set(i, f.get(j));
        f.set(j, tmp);
    }

    static <T> void rotate(Folge<T> f, int d) {
        int n = f.size();
        if(n == 0 || d % n == 0) {
            return;
        }

        //reverse first part
        reverse(f,0, d-1 );
        //reverse second part
        reverse(f,d,n-1);
        //reverse all
        reverse(f,0,n-1);

    }

    private static <T> void reverse(Folge<T> f, int start, int end) {
        while( start < end) {
            swap(f, start, end);
            start++;
            end--;
        }
    }


}
