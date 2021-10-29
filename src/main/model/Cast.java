package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistance.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class references code from this IntegerSet repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/IntegerSetLecLab.git

// This class references code from this JsonSerializationDemo repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// A cast of contestants.
public class Cast implements Writable {
    private String name;                  //This is the name of the team
    private int id;                       //This is the ID of the team
    private ArrayList<Contestant> cast;   //The contestants in the cast

    // Constructs an empty cast of contestants. We must name the cast and give it an account ID.
    public Cast(String castName, int accountID) {
        cast = new ArrayList<>();
        name = castName;
        id = accountID;
    }

    public String getCastName() {
        return name;
    }

    public void setCastName(String newName) {
        name = newName;
    }

    public int getID() {
        return id;
    }

    // REQUIRES: A contestant.
    // MODIFIES: This.
    // EFFECTS: Contestant c is added to the Cast if they're not already in it.
    public void add(Contestant c) {
        if ((!cast.contains(c)) && (cast.size() < 3)) {
            cast.add(c);
        }
    }

    // REQUIRES: Contestant c is in the Cast.
    // MODIFIES: This.
    // EFFECTS: Contestant c is removed from the Cast.
    public void remove(Contestant c) {
        cast.remove(c);
    }

    // EFFECTS: Returns the number of contestants in the Cast.
    public int size() {
        return cast.size();
    }

    // REQUIRES: A contestant.
    // EFFECTS: Returns true if contestant c is already in the cast, otherwise returns false.
    public boolean contains(Contestant c) {
        return cast.contains(c);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("contestant", fullCastToJson());
        return json;
    }

    private JSONArray fullCastToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Contestant c : cast) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }

    public List<Contestant> getContestants() {
        return Collections.unmodifiableList(cast);
    }
}

