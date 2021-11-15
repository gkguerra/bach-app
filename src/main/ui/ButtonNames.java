package ui;

public enum ButtonNames {
    SIGNUP("Create a new account"),
    LOGIN("Log in to an existing account");

    private final String name;

    ButtonNames(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }

}
