package LLD.TicTacToeLowLevelDesign.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    PlayingPiece [][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    

    public int getSize() {
        return size;
    }



    public void setSize(int size) {
        this.size = size;
    }



    public PlayingPiece[][] getBoard() {
        return board;
    }



    public void setBoard(PlayingPiece[][] board) {
        this.board = board;
    }



    public boolean addPiece(int row,int col,PlayingPiece piece) {
        if(board[row][col] == null) {
            board[row][col] = piece;
            return true;
        }
        return false;
    }

    public List<Pair> getEmptySpaces() {
        List<Pair> emptySpaces = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    emptySpaces.add(new Pair(i, j));
                }
            }
        }
        return emptySpaces;
    }


    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]==null ? "   |" : " " + board[i][j].getPieceType() +  " |");
            }
            System.out.println();
        }
    }
}


class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}