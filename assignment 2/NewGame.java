import java.util.Scanner;

import Bot;
import Player;
import Gameplay;

public abstract class NewGame {
    private static Scanner userInput;

    public static void newSession() {
        userInput = new Scanner(System.in);

        //1. Boring configuration first...
        System.out.println("Welcome to Connect4!");
        System.out.println("...Game settings...");

        //2. Choose between single or multi-player
        System.out.println("Do you want a single-player (1) or multi-player (2) session? Choose between 1 or 2...");

        Integer singleOrMultiOption = userInput.nextInt();
        singleOrMultiValidation(singleOrMultiOption);

        //3. Color for player1!
        System.out.println("For player1, what color do you like most? RED (1), YELLOW (2) or BLUE (3)? Choose between 1, 2 or 3!");
        
        Integer player1ColorOption = userInput.nextInt();
        colorOptionValidation(player1ColorOption);

        //4. Color for player2/robot!
        System.out.println("For the 2nd player, which color will you choose? RED (1), YELLOW (2) or BLUE (3)? Choose between 1, 2 or 3!");

        Integer player2ColorOption = userInput.nextInt();
        colorOptionValidation(player2ColorOption);
        secondColorValidation(player1ColorOption, player2ColorOption);

        //5. Let's create the players!
        Player player1 = createPlayer(player1ColorOption);
        Player player2 = createPlayer(player2ColorOption);

        //6. Gameplay!
        if (singleOrMultiOption == 1) { //Single-player!
            new Gameplay(player1, new Bot(player2.getFullColorName()));
        } else {                        //Multi-player
            new Gameplay(player1, player2);
        }
    }

    private static void singleOrMultiValidation(Integer option) {
        if (option != 1 && option != 2) {
            throw new Error("You were supposed to choose between '1' or '2'!");
        }
    }

    private static void colorOptionValidation(Integer option) {
        if (option < 1 && option > 3) {
            throw new Error("Invalid input!");
        }
    }

    private static void secondColorValidation(Integer player1Option, Integer player2Option) {
        if (player1Option == player2Option) {
            throw new Error("Both players must have different colors!");
        }
    }

    private static Player createPlayer (Integer option) {
        switch (option) {
            case 1:
                return Player.RED;
            case 2:
                return Player.YELLOW;
            case 3:
                return Player.BLUE;
            default:
                break;
        }
        return null;
    }
    
}
