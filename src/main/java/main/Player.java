package main;

// Player.java
public class Player {
    private char marker;

    public Player(char marker) {
        this.marker = marker;
    }

    public char getMarker() {
        return marker;
    }

    @Override
    public String toString() {
        return String.valueOf(marker);
    }
}
