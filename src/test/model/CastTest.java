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
        testCast = new Cast();
        c1 = new Contestant("Chad Smith", "Florida",
                "Chad grew up a wrestler.",
                0, 0,0,0,0,"None","Eligible");
        c2 = new Contestant("Jack Bob", "Atlanta",
                "Jack is unemployed.",
                0, 0,0,0,0,"None","Eligible");
        c3 = new Contestant("Andrew Mah", "California",
                "Andrew goes to the gym.",
                0, 0,0,0,0,"None","Eligible");
    }

    @Test
    public void addToEmptyTest() {
        testCast.add(c1);
        assertEquals(1, testCast.size());
        // assertTrue(testCast.contains(c1));
    }

    @Test
    public void addManyTest() {
        testCast.add(c1);
        testCast.add(c2);
        testCast.add(c3);
        assertEquals(3, testCast.size());
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
    public void removeFromEmptyTest() {
        testCast.remove(c1);
        assertEquals(0, testCast.size());
    }

    }

    //size, remove, and add
