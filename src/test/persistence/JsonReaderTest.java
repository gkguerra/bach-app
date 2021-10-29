package persistence;

import model.Contestant;
import model.Cast;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Cast cast = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCast() {
        JsonReader reader = new JsonReader("./data/testWriterEmptyCast.json");
        try {
            Cast cast = reader.read();
            assertEquals("My Cast", cast.getCastName());
            assertEquals(0, cast.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCast() {
        JsonReader reader = new JsonReader("./data/testWriterGeneralCast.json");
        try {
            Cast cast = reader.read();
            assertEquals("My Cast", cast.getCastName());
            List<Contestant> cast1 = cast.getContestants();
            assertEquals(2, cast.size());
            checkContestant("Mark", "LA",1,1,"Eligible", 2, cast1.get(0));
            checkContestant("Twain", "NYC",1,1,"Eligible", 2, cast1.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}