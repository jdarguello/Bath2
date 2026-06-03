import java.util.Random;

import Board;
import Player;

public class Bot {
    
    Player player;

    public Bot(String color) {
        player = chooseBotPlayer(color);
    }

    public Player getPlayer() {
        return player;
    }

    //Player should choose bot's color
    private Player chooseBotPlayer (String color) {
        switch (color.toUpperCase()) {  //We guarantee that it doesn't matter user input, while it reads a valid color...
            case "RED":
                return Player.RED;
            case "BLUE":
                return Player.BLUE;
            case "YELLOW":
                return Player.YELLOW;
            default:
                throw new Error("Bot player must be 'Red', 'Blue' or 'Yellow'");
        }
    }

    //Bot player should put its ball in a random position...
    public void play(Board board) throws Exception {
        board.setPosition(validNumber(), player);
    }

    //Guarantees that the bot sets a valid position in the board!
    private Integer validNumber() {
        Random rand = new Random();   
        Boolean valid = false;
        Integer number = null;
        while (!valid) {
            try {
                number = rand.nextInt(7) + 1;
                if (number != null && number >= 1 && number <= 7) {
                    valid = true;
                }
            } catch (Exception e) {
                
            }
        }
        return number;
    }

}
