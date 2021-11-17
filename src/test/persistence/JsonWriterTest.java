package persistence;

import model.Cast;
import model.Contestant;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// This class references code from this JsonSerializationDemo repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            Cast c = new Cast("My Cast", 1234);
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyCast() {
        try {
            Cast c = new Cast("My Cast", 123);
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCast.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCast.json");
            c = reader.read();
            assertEquals("My Cast", c.getCastName());
            assertEquals(0, c.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralCast() {
        try {
            Cast c = new Cast("My Cast", 123);
            c.addContestant(new Contestant("Mark", "LA",1,1,"Eligible"));
            c.addContestant(new Contestant("Twain", "NYC",1,1,"Eligible"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCast.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCast.json");
            c = reader.read();
            assertEquals("My Cast", c.getCastName());
            List<Contestant> cast2 = c.getContestants();
            assertEquals(2, cast2.size());
            checkContestant("Mark", "LA",1,1,"Eligible", 2, cast2.get(0));
            checkContestant("Twain", "NYC",1,1,"Eligible", 2, cast2.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
