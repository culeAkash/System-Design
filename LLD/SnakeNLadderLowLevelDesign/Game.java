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

            int newPosition = currentPosition + roll;

            System.out.println("Player " + currentPlayer.playerId + " rolled " + roll + " and moved from " + currentPosition + " to " + newPosition + "by " + roll);

            if(newPosition == board.cells.length * board.cells.length - 1){
                winnerPlayer = currentPlayer;
                break;
            }

            if(newPosition > board.cells.length * board.cells.length - 1){
                System.out.println("Invalid move. Position out of bounds.");
                continue;
            }


            // move the player after checking if any jump exists at the new position
            Cell cell = board.getCell(newPosition);

            while(cell.jump != null && cell.jump.start == newPosition){
                String jumpType = cell.jump.start >= cell.jump.end ? "Snake" : "Ladder";
                System.out.println("Jumped " + jumpType + " from " + cell.jump.start + " to " + cell.jump.end);
                int nextCellPosition = cell.jump.end;
                newPosition = nextCellPosition;
                cell = board.getCell(nextCellPosition);
            }

            currentPlayer.currentPosition = newPosition;
            System.out.println("Player " + currentPlayer.playerId + " moved from " + currentPosition + " to " + newPosition);

            // check winning move
            if(newPosition == board.cells.length * board.cells.length - 1){
                winnerPlayer = currentPlayer;
                break;
            }
        }

        if(winnerPlayer != null){
            System.out.println("Player " + winnerPlayer.playerId + " won the game!");
        }
    }

    private Player getCurrentPlayer(){
        Player currentPlayer = this.players.pollFirst();
        this.players.addLast(currentPlayer);
        return currentPlayer;
    }
}
