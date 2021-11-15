package model;

import persistence.JsonReader;
import persistence.JsonWriter;

import java.util.ArrayList;
import java.util.List;

public class BachGame {
    private static String JSON_STORE;
    private Cast cast;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private List<Cast> casts;

    public BachGame() {
        casts = new ArrayList<>();
    }

}
