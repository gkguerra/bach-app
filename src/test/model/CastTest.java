package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CastTest {
    private Cast testCast;
    private Contestant c1;
    private Contestant c2;
    private Contestant c3;

    @BeforeEach
    public void runFirst() {
        testCast = new Cast("Test Cast", 123);
        c1 = new Contestant("Chad Smith", "Florida", 2, 0, "Eligible");
        c2 = new Contestant("Jack Bob", "Atlanta", 0, 0, "Eligible");
        c3 = new Contestant("Andrew Mah", "California", 0, 0, "Eligible");
    }

    @Test
    public void getNameTest() {
        assertEquals("Chad Smith", c1.getName());
    }

    @Test
    public void getHometown() {
        assertEquals("Florida", c1.getHometown());
    }

    @Test
    public void getRoses() {
        assertEquals(0, c1.getRoses());
    }

    @Test
    public void getDates() {
        assertEquals(0, c1.getDates());
    }

    @Test
    public void getStatus() {
        assertEquals("Eligible", c1.getStatus());
    }


    @Test
    public void getCastNameTest() {
        assertEquals("Test Cast", testCast.getCastName());
    }

    @Test
    public void getIDTest() {
        assertEquals(123, testCast.getID());
    }


    @Test
    public void addToEmptyTest() {
        testCast.add(c1);
        assertEquals(1, testCast.size());
        assertTrue(testCast.contains(c1));
    }

    @Test
    public void addManyTest() {
        testCast.add(c1);
        testCast.add(c2);
        testCast.add(c3);
        assertEquals(3, testCast.size());
        assertTrue(testCast.contains(c1));
        assertTrue(testCast.contains(c2));
        assertTrue(testCast.contains(c3));
    }

    @Test
    public void addButAlreadyThereTest() {
        testCast.add(c1);
        testCast.add(c1);
        assertTrue(testCast.contains(c1));
        assertEquals(1, testCast.size());
    }

    @Test
    public void removeTest() {
        testCast.add(c1);
        testCast.add(c2);
        assertEquals(2, testCast.size());
        testCast.remove(c2);
        assertEquals(1, testCast.size());
    }

    @Test
    public void removeButNotThereTest() {
        testCast.add(c1);
        testCast.remove(c2);
        assertEquals(1, testCast.size());
        assertTrue(testCast.contains(c1));
    }

    @Test
    public void removeFromEmptyTest() {
        testCast.remove(c1);
        assertEquals(0, testCast.size());
    }

    }
