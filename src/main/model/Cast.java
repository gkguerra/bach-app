package model;

import java.util.ArrayList;
import java.util.List;

public class Cast {
    private String castName;           //the name of your cast
    private List<Contestant> cast;
    private int overallScore;         // overall score of the cast calculated from contestant information
    private Contestant c1;
    private Contestant c2;
    private Contestant c3;

    public Cast() {
        cast = new ArrayList<>();
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
        if (cast.contains(c)) {
            cast.remove(c);
        }
    }

    // EFFECTS: Returns the number of contestants in the Cast
    public int size() {
        return cast.size();
    }
}

