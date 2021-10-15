package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// This test class references code from this IntegerSet repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/IntegerSetLecLab.git

class CastTests {
    private Cast testCast;
    private Contestant c1;
    private Contestant c2;
    private Contestant c3;
    private Contestant c4;

    @BeforeEach
    public void runFirst() {
        testCast = new Cast("Test Cast", 123);
        c1 = new Contestant("Chad Smith", "Florida", 0, 0, "Eligible");
        c2 = new Contestant("Jack Bob", "Atlanta", 0, 0, "Ineligible");
        c3 = new Contestant("Andrew Mah", "California", 1, 3, "Eligible");
        c4 = new Contestant("Jason Chase", "Chicago", 2, 1, "Eligible");
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
    public void addToFullTest() {
        testCast.add(c1);
        testCast.add(c2);
        testCast.add(c3);
        testCast.add(c4);
        assertEquals(3, testCast.size());
        assertTrue(testCast.contains(c1));
        assertTrue(testCast.contains(c2));
        assertTrue(testCast.contains(c3));
        assertFalse(testCast.contains(c4));
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
