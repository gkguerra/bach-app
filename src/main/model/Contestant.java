package model;

public class Contestant {
    private final String name;      // contestant's name
    private final String hometown;  // contestant's hometown
    private int roses;              // number of roses a contestant has received
    private int dates;              // number of dates a contestant has been one
    private String status;          // contestant status (either eliminated, safe, or eligible)

    public Contestant(String name, String hometown, int roses, int dates, String status) {
        this.name = name;
        this.hometown = hometown;
        this.roses = 0;
        this.dates = 0;
        this.status = "Eligible";
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

}
