package LLD.TicTacToeLowLevelDesign;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import LLD.TicTacToeLowLevelDesign.models.Board;
import LLD.TicTacToeLowLevelDesign.models.CrossPiece;
import LLD.TicTacToeLowLevelDesign.models.NoughtPiece;
import LLD.TicTacToeLowLevelDesign.models.Player;
import LLD.TicTacToeLowLevelDesign.models.PlayingPiece;

public class TicTacToeGame {
    Deque<Player> players;
    Board board;

    public void initializeGame() {
        this.players = new ArrayDeque<>();
        // create player 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player 1 name : ");
        String player1Name = sc.nextLine(); 

        Player player1 = new Player(player1Name, new CrossPiece());

        players.addLast(player1);

        // create player 2
        System.out.println("Enter player 2 name : ");
        String player2Name = sc.nextLine(); 

        Player player2 = new Player(player2Name, new NoughtPiece());
        players.addLast(player2);

        // create board
        // System.out.println("Enter board size : ");
        // int boardSize = sc.nextInt();

        board = new Board(3);
        startGame();
        sc.close();
    }


    public void startGame() {
        System.out.println("Game started");

        boolean gameOver = false;

        while(!gameOver){
            // print board
            this.board.printBoard();

            // check if game is drawn
            if(this.board.getEmptySpaces().size() == 0){
                System.out.println("Game is drawn");
                break;
            }


            // pick the first player who will play
            Player playerToPlay = players.removeFirst();
            System.out.println("Player " + playerToPlay.getName() + " will play");
            // get the position of the player to play

            Scanner sc = new Scanner(System.in);
                System.out.println("Enter the position(1-9) : ");
                int position = sc.nextInt();

                int row = (position - 1) / 3 ;
                int col = (position - 1) % 3;

                boolean isAdded = this.board.addPiece(row, col, playerToPlay.getPlayingPiece());

                if(!isAdded){
                    System.out.println("Invalid position, Please try again");
                    players.addFirst(playerToPlay);
                    continue;
                }

                players.addLast(playerToPlay);

                // check if after present move current player has won
                boolean winner = isWinner(row,col,playerToPlay.getPlayingPiece());

                if(winner){
                    System.out.println("Player " + playerToPlay.getName() + " won");
                    break;
                
            }
        }
        
    }

    private boolean isWinner(int row,int col,PlayingPiece piece) {

        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // check for rows
        for(int j=0;j<this.board.getSize();j++){
            if(board.getBoard()[row][j]==null || board.getBoard()[row][j].getPieceType()!=piece.getPieceType()){
                rowMatch = false;
                break;
            }
        }

        // check for columns
        for(int i=0;i<this.board.getSize();i++){
            if(board.getBoard()[i][col]==null || board.getBoard()[i][col].getPieceType()!=piece.getPieceType()){
                colMatch = false;
                break;
            }
        }

        // check for diagonal
        for(int i=0,j=0;i<this.board.getSize();i++,j++){
            if(this.board.getBoard()[i][j]==null || this.board.getBoard()[i][j].getPieceType()!=piece.getPieceType()){
                diagonalMatch = false;
                break;
            }
        }

        // check for anti diagonal
        for(int i=0,j=this.board.getSize()-1;i<this.board.getSize();i++,j--){
            if(this.board.getBoard()[i][j]==null || this.board.getBoard()[i][j].getPieceType()!=piece.getPieceType()){
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
