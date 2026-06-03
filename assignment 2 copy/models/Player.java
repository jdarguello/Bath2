package models;

public enum Player {
    RED('r', "RED"), YELLOW('y', "YELLOW"), 
        BLUE('b', "BLUE");

    private final char color;
    private final String fullColorName;

    Player(char color, String fullColorName) {
        this.color = color;
        this.fullColorName = fullColorName;
    }

    public char playerColor() {
        return color;
    }

    public String getFullColorName() {
        return fullColorName;
    }
}
