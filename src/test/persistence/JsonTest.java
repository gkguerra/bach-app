package persistence;

import model.Cast;
import model.Contestant;

import static org.junit.jupiter.api.Assertions.*;

// This class references code from this JsonSerializationDemo repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonTest {

    protected void checkContestant(String name, String hometown, int roses,
                                   int dates, String status, int score,  Contestant contestant) {
        assertEquals(name, contestant.getName());
        assertEquals(hometown, contestant.getHometown());
        assertEquals(roses, contestant.getRoses());
        assertEquals(dates, contestant.getDates());
        assertEquals(status, contestant.getStatus());
        assertEquals(score, contestant.getScore());

    }
}
