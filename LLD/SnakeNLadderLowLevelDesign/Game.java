package LLD.SnakeNLadderLowLevelDesign;

import java.util.ArrayDeque;
import java.util.Deque;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players;
    Player winnerPlayer;

    public Game(){
        initializeGame();
    }

    private void initializeGame(){
        board = new Board(10,7,5);
        dice = new Dice(2);
        winnerPlayer = null;
        addPlayers();
    }

    private void addPlayers(){
        players = new ArrayDeque<>();
        players.add(new Player("player1", 0));
        players.add(new Player("player2", 0));
    }

    public void startGame(){
        while(winnerPlayer == null){
            Player currentPlayer = getCurrentPlayer();
            System.out.println("Current player: " + currentPlayer.playerId);
            int roll = dice.rollDice();

            int currentPosition = currentPlayer.currentPosition;

            //TODO :  add logic to move the player and also check if the player has reached the end of the board
        }
    }

    private Player getCurrentPlayer(){
        Player currentPlayer = this.players.pollFirst();
        this.players.addLast(currentPlayer);
        return currentPlayer;
    }
}
