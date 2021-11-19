package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.BachGameJFrame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BachGameTests {
    BachGame bg;

    @Test
    public void addTest() {
        assertNotNull(bg = new BachGame());
    }

}
