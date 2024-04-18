package Prog2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestPaar {
    static Paar<String, Integer> paar1;
    static Paar<String, Integer> paar2;

@BeforeEach
void init() {
    paar1 = new Paar<> ("Hallo", 5);
    paar2 = new Paar<> ("Hi", 1);
}

    @Test
    public void testEquals() {
        assertEquals(paar1, paar2);
    }
}
