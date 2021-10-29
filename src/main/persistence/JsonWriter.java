package persistence;

import model.Cast;
import org.json.JSONObject;

import java.io.*;

// This class references code from this JsonSerializationDemo repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a writer which writes JSON representation of Cast to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to this destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: This.
    // EFFECTS: Opens the writer, throws FileNotFoundException if destination file cannot be opened
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: This.
    // EFFECTS: writes JSON representation of a Cast to file
    public void write(Cast cast) {
        JSONObject json = cast.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: This.
    // EFFECTS: Closes the writer.
    public void close() {
        writer.close();
    }

    // MODIFIES: This.
    // EFFECTS: Writes string to file.
    public void saveToFile(String json) {
        writer.print(json);
    }
}
