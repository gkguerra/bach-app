package persistence;

import model.Cast;
import model.Contestant;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// This class references code from this JsonSerializationDemo repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// A reader that reads a Cast from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: Constructs a reader which reads from the source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads cast from file and returns it, throws
    // IOException if an error occurs reading data from file
    public Cast read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCast(jsonObject);
    }

    // EFFECTS: Reads and returns the source file as a string
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: Parses Cast from JSON object and returns it
    private Cast parseCast(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Cast cast = new Cast("My Cast", 1234);
        System.out.print("Test");
        addContestants(cast, jsonObject);
        return cast;
    }

    // MODIFIES: Cast
    // EFFECTS: Parses contestants from JSON object and adds them to Cast
    private void addContestants(Cast cast, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("contestant");
        for (Object json : jsonArray) {
            JSONObject nextContestant = (JSONObject) json;
            addContestant(cast, nextContestant);
        }
    }

    // MODIFIES: Cast
    // EFFECTS: Parses contestant from JSON object and adds it to cast
    private void addContestant(Cast cast, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String hometown = jsonObject.getString("hometown");
        int roses = jsonObject.getInt("roses");
        int dates = jsonObject.getInt("dates");
        String status = jsonObject.getString("status");

        Contestant c = new Contestant(name, hometown, roses, dates, status);
        cast.add(c);
    }
}
