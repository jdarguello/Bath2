package models.interfaces;

import Player;

public interface Stack {
    public void placeCounter(Player player);
    public String printRow(int position);
}
