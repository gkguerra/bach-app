package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This class references code from this IntegerSet repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/IntegerSetLecLab.git

public class ContestantTests {
    private Contestant c1;
    private Contestant c2;
    private Contestant c3;
    private Contestant c4;

    @BeforeEach
    public void runFirst() {
        c1 = new Contestant("Chad Smith", "Florida", 0, 0, "Eligible");
        c2 = new Contestant("Jack Bob", "Atlanta", 0, 0, "Not eligible");
        c3 = new Contestant("Andrew Mah", "California", 1, 3, "Eligible");
        c4 = new Contestant("Jason Chase", "Chicago", 2, 1, "Eligible");
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
        assertEquals(1, c3.getRoses());
    }

    @Test
    public void getRosesZero() {
        assertEquals(0, c1.getRoses());
    }


    @Test
    public void getDatesZero() {
        assertEquals(0, c1.getDates());
    }

    @Test
    public void getDates() {
        assertEquals(3, c3.getDates());
    }

    @Test
    public void getStatus() {
        assertEquals("Eligible", c1.getStatus());
    }

    @Test
    public void getStatusIneligible() {
        assertEquals("Not eligible", c2.getStatus());
    }

    @Test
    public void getScore() {
        assertEquals(3, c4.getScore());
    }

    @Test
    public void getScoreZero() {
        assertEquals(0, c1.getScore());
    }

    @Test
    public void toStringTest() {
        assertEquals(c1.getDates() + ":" + c1.getName(), c1.toString());
    }

}
