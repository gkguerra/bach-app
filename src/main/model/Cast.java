package model;

import java.util.ArrayList;
import java.util.List;

public class Cast {
    private static int maxMembers = 3; //the maximum numbers of contestants you can add to a cast
    private String castName;           //the name of your cast
    private List<Contestant> cast;
    private int overallScore; // overall score of the cast calculated from contestant information

    public Cast() {
        cast = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Contestant c is added to the Cast if they're not already in it
    public void add(Contestant c) {
    }

    // REQUIRES: Contestant c is in the Cast
    // MODIFIES: this
    // EFFECTS: Contestant c is removed from the Cast
    public void remove(Contestant c) {
    }

    // EFFECTS: Returns the number of contestants in the Cast
    public int size() {
        return 0; //stub
    }

    // EFFECTS: Calculates and returns the overall score of the Cast
    public int score(Contestant c) {
        return 0; //stub
    }

}

