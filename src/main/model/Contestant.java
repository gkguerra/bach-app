package model;

public class Contestant {
    private final String name;      // contestant's name
    private final String hometown;  // contestant's hometown
    private int roses;              // number of roses a contestant has received
    private int dates;              // number of dates a contestant has been one
    private String status;          // contestant status (either eliminated, safe, or eligible)
    private int score;              // the contestant's score (based on number of roses and dates)

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
