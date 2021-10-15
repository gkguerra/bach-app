package model;

// A contestant on the Bachelorette.
public class Contestant {
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

}
