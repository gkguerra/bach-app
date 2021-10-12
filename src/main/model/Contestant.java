package model;

public class Contestant {
    private final String name;      // contestant's name
    private final String hometown;  // contestant's hometown
    private final String biography; // contestant's biography
    private int roses;              // number of roses a contestant has received
    private int dates;              // number of dates a contestant has been one
    private int affirmation;        // number of times a contestant has received "words of affirmation"
    private int openUp;             // number of times a contestant has "opened up" and
                                    // shared something about themselves to the lead
    private int drama;              // number of instances a participant has been involved in drama
    private String powerUps;        // "Jimmy's wife chooses, first impression rose, first one-on-one"
    private String status;          // contestant status (either eliminated, safe, or eligible)

    public Contestant(String name, String hometown, String biography, int roses, int dates, int affirmation,
                      int openUp, int drama, String powerUps, String status) {
        this.name = name;
        this.hometown = hometown;
        this.biography = biography;
        this.roses = 0;
        this.dates = 0;
        this.affirmation = 0;
        this.openUp = 0;
        this.drama = 0;
        this.powerUps = "None";
        this.status = "Eligible";
    }

    public String getName() {
        return name;
    }

    public String getHometown() {
        return hometown;
    }

    public String getBiography() {
        return biography;
    }

    public int getRoses() {
        return roses;
    }

    public int getDates() {
        return dates;
    }

    public int getAffirmation() {
        return affirmation;
    }

    public int getOpenUp() {
        return openUp;
    }

    public int getDrama() {
        return drama;
    }

    public String getPowerUps() {
        return powerUps;
    }

    public String getStatus() {
        return status;
    }

}
