package UA91;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestStud {

    private Stud a, b, c;

    @BeforeEach
    public void init() {
        a = new Stud("Aaa");
        b = new Stud("Bbb");
        c = new Stud("Ccc");

    }

    @Test
    public void test() {
        Assertions.assertTrue(a.compareTo(b) < 0);
        Assertions.assertTrue(c.compareTo(a) > 0);
        Assertions.assertEquals(0, c.compareTo(c));
    }
}
