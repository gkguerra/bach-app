package model;

import java.util.ArrayList;

public class Cast {
    private final String name; //This is the name of the team
    private final int id;
    private final ArrayList<Contestant> cast; //The contestants in the cast

    public Cast(String castName, int accountID) {
        cast = new ArrayList<>();
        name = castName;
        id = accountID;
    }

    // help from IntegerSet lab

    public String getCastName() {
        return name;
    }

    public int getID() {
        return id;
    }

    // MODIFIES: this
    // EFFECTS: Contestant c is added to the Cast if they're not already in it
    public void add(Contestant c) {
        if (!cast.contains(c)) {
            cast.add(c);
        }
    }

    // REQUIRES: Contestant c is in the Cast
    // MODIFIES: this
    // EFFECTS: Contestant c is removed from the Cast
    public void remove(Contestant c) {
        cast.remove(c);
    }

    // EFFECTS: Returns the number of contestants in the Cast
    public int size() {
        return cast.size();
    }

    public boolean contains(Contestant c) {
        return cast.contains(c);
    }

}

