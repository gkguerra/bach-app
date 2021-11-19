package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// This class references code from this source:
// https://www.cs.cornell.edu/courses/JavaAndDS/eclipse/Ecl09JUnitTestConstructor.html

public class BachGameTests {
    BachGame bg;

    @Test
    public void addTest() {
        assertNotNull(bg = new BachGame());
    }

}
