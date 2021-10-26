package model;

import org.json.JSONObject;
import persistance.Writable;

// This class references code from this JsonSerializationDemo repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// A contestant on the Bachelorette.
public class Contestant implements Writable {
    private final String name;      //Contestant's name
    private final String hometown;  //Contestant's hometown
    private int roses;              //Number of roses a contestant has received
    private int dates;              //Number of dates a contestant has been one
    private String status;          //Contestant status (either eliminated, safe, or eligible)
    private int score;              //The contestant's score (based on number of roses and dates)

    //EFFECTS: Creates a new contestant. Must specify the contestant's name, hometown, number of roses, number of
    // dates, and current status.
    public Contestant(String name, String hometown, int roses, int dates, String status) {
        this.name = name;
        this.hometown = hometown;
        this.roses = roses;
        this.dates = dates;
        this.status = status;
        this.score = roses + dates;
    }

    public String getName() {
        return name;
    }

    public String getHometown() {
        return hometown;
    }

    public int getRoses() {
        return roses;
    }

    public int getDates() {
        return dates;
    }

    public String getStatus() {
        return status;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return dates + ":" + name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("hometown", hometown);
        json.put("roses", roses);
        json.put("dates", dates);
        json.put("eligible", status);
        json.put("score", score);
        return json;
    }

}
