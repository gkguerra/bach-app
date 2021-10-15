package model;

import java.util.ArrayList;

public class Cast {
    private final String name; //This is the name of the team
    private final ArrayList<Contestant> cast; //The contestants in the cast

    public Cast(String castName) {
        cast = new ArrayList<>();
        name = castName;
    }

    // help from IntegerSet lab

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

    public Cast contestant(Cast other) {
        Cast contestant = new Cast("Jonathan's Cast");

        for (Contestant next: cast) {
            if (other.contains(next)) {
                contestant.add(next);
            }
        }

        return contestant;
    }
}

