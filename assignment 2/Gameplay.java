import java.util.Scanner;

import Bot;
import Player;
import WinningConditions;

public class Gameplay extends WinningConditions implements Rules {

    private Player player1;
    private Player player2;
    private Bot robot;

    private Scanner userInput;

    //A new Gameplay, a new Board to play!
    public Gameplay() {
        super();        //<= creates a white board!
        userInput = new Scanner(System.in);
        gameSession();
    }

    //Multiplayer-option
    public Gameplay (Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this();                     //New Gameplay!
    }

    //Single player!
    public Gameplay (Player player1, Bot robot) {
        this.player1 = player1;
        this.robot = robot;
        this();                     //New Gameplay!
    }

    public void gameSession() {
        Boolean player1Turn = true;     //First to create, first to play!
        Player winner = null;           //There's no winner yet!

        System.out.println("New Game! Let's Rock'N'Roll!");
        board.display();
        
        while (!haveYouWon()) {         //Loop will run until there's a winner!
            //1. Make your choice!
            if (player1Turn) {
                yourTurn(player1);
                player1Turn = false;

                winner = player1;   //If you've won, congrats...
            } else if (!player1Turn && robot == null) { //2nd player's turn!
                yourTurn(player2);
                player1Turn = true;

                winner = player2;   //If you've won, congrats...
            } else if (robot != null) {    //Bot's turn!
                yourTurn(robot);
                player1Turn = true;

                winner = robot.getPlayer();  //If you've won, congrats...
            }

            //2. Print the board!
            board.display();
        }

        //3. Let's all hail the winner!
        if (winner == null) {
            throw new Error("There should be a winner, but there isn't... something weird happened!");
        }
        System.out.println("Congratulations player " + winner.getFullColorName() + "! You're the winner!");

    }

    //Player's turn!
    @Override
    public void yourTurn(Player player) {
        //1. Player must set his/her move!
        System.out.println("Your turn player " + player.getFullColorName() + 
            "! Make your move (choose between 1 and 7)");
    
        Integer position = userInput.nextInt();
        try {
            board.setPosition(position, player);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Bot's turn!
    @Override
    public void yourTurn(Bot robot) {
        try {
            robot.play(board);
        } catch (Exception e) {
            System.out.println("Bot's error: " + e.getMessage());
        }
    }

    //Are players valid? They shouldn't have same colors!
    @Override
    public Boolean differentColors(Player player1, Player player2) {
        return player1.playerColor() != player2.playerColor(); 
    }
}
