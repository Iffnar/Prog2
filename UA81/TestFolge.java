package UA81;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

class TestFolge {
	
	Folge<Integer> f;
	Folge<Integer> f5;
	
	@BeforeEach
	void init() {
		// f = leere Folge
		// f5 = [1, 2, 3, 4, 5]
		f = new FolgeAlsDVL<>();
		f5 = new FolgeAlsDVL<>();
		for (int i = 1; i <= 5; i++)
			f5.addLast(i);
	}

	@Test
	void testInitLeer() {
		assertEquals(0, f.size());
		assertTrue(f.isEmpty());
		assertFalse(f.contains(1));
		assertThrows(NoSuchElementException.class, ()->{f.pos(0);});
	}
	
	@Test
	void testIterator() {
		Iterator<Integer> it = f5.iterator();
		int i = 1;
		while(it.hasNext()) {
			assertEquals(i++, it.next());
		}
	}
	
	@Test
	void testInitF5() {
		assertEquals(5, f5.size());
		assertFalse(f5.isEmpty());
		assertTrue(f5.contains(1));
		assertTrue(f5.contains(3));
		assertTrue(f5.contains(5));
		assertFalse(f5.contains(12));
		f5.addLast(3);
		assertEquals(6, f5.size());
	}
	
	@Test
	void testGet() {
		assertEquals(1, f5.get(0));
		assertEquals(5, f5.get(4));
		assertThrows(IndexOutOfBoundsException.class, () -> {f5.get(5);});
		assertThrows(IndexOutOfBoundsException.class, () -> {f.get(0);});
	}
	
	@Test
	void testSet() {
		f5.set(0, 10);
		f5.set(4, 50);
		assertEquals(10, f5.get(0));
		assertEquals(50, f5.get(4));
		assertThrows(IndexOutOfBoundsException.class, () -> {f5.set(-1,  20);});
	}
	
	@Test
	void testPos() {
		assertThrows(NoSuchElementException.class, () -> {f.pos(3);});
		assertEquals(0, f5.pos(1));
		assertEquals(4, f5.pos(5));
		f5.addLast(3);
		assertEquals(2, f5.pos(3));
	}
	
	@Test
	void testAddFirst() {
		f.addFirst(10);
		assertEquals(1, f.size());
		f5.addFirst(10);
		assertEquals(6, f5.size());
		assertEquals(10, f5.get(0));
	}
	
	@Test
	void testInsertErstes() {
		f.insert(0,  2);
		assertEquals(1, f.size());
		assertEquals(2, f.get(0));
		f5.insert(0, 8);
		assertEquals(6, f5.size());
		assertEquals(8, f5.get(0));
	}
	
	@Test
	void testInsertLetztes() {
		f5.insert(5,  8);
		assertEquals(6, f5.size());
		assertEquals(8, f5.get(5));
	}
	
	@Test
	void testInsertMittig() {
		f5.insert(3,  8);
		assertEquals(6, f5.size());
		assertEquals(3, f5.get(2));
		assertEquals(8, f5.get(3));
		assertEquals(4, f5.get(4));
	}
	
	
	@Test
	void testRemoveErstes() {
		f5.remove(0);
		assertEquals(4, f5.size());
		assertFalse(f5.contains(1));
	}
	
	@Test
	void testRemoveLetztes() {
		f5.remove(4);
		assertEquals(4, f5.size());
		assertFalse(f5.contains(5));
	}
	
	@Test
	void testRemoveEinziges() {
		f.addLast(1);
		f.remove(0);
		assertEquals(0, f.size());
		assertFalse(f.contains(1));
	}
	
	@Test
	void testRemoveMitte() {
		f5.remove(2);
		assertEquals(4, f5.size());
		assertFalse(f5.contains(3));
	}
	
	@Test
	void RemoveNichtvorkommendes() {
		assertThrows(IndexOutOfBoundsException.class, () -> {f5.remove(10);});
		assertEquals(5, f5.size());
	}
	
	
	@Test
	void testDeleteErstes() {
		f5.delete(1);
		assertEquals(4, f5.size());
		assertFalse(f5.contains(1));
	}
	
	@Test
	void testDeleteLetztes() {
		f5.delete(5);
		assertEquals(4, f5.size());
		assertFalse(f5.contains(5));
	}
	
	@Test
	void testDeleteEinziges() {
		f.addLast(1);
		f.delete(1);
		assertEquals(0, f.size());
		assertFalse(f.contains(1));
	}
	
	@Test
	void testDeleteMitte() {
		f5.delete(2);
		assertEquals(4, f5.size());
		assertFalse(f5.contains(2));
	}
	
	@Test
	void deleteNichtvorkommendes() {
		f5.delete(10);
		assertEquals(5, f5.size());
	}
	
	@Test
	void testDuplikatVorne() {
		f5.addLast(1);
		f5.delete(1);
		assertEquals(5, f5.size());
		assertTrue(f5.contains(1));
	}
	
	@Test
	void testDuplikatHinten5() {
		f5.addLast(5);
		f5.delete(5);
		assertEquals(5, f5.size());
		assertTrue(f5.contains(5));
	}
	
}
