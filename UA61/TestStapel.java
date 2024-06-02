package UA61;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestStapel {

    private Stapel<Integer> uut;

    @BeforeEach
    public void init() {
        uut = new StapelEVL<>();
    }

    @Test
    public void test() {
        assertTrue(uut.isEmpty());
        uut.push(5);
        assertFalse(uut.isEmpty());
        assertEquals(5, uut.top());

        uut.pop();
        assertThrows(NoSuchElementException.class, () -> {uut.top();});
        uut.push(5);
        uut.push(6);
        uut.pop();
        assertEquals(5, uut.top());
    }

}
