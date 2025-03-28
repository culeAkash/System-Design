package LLD.SnakeNLadderLowLevelDesign;

public class Board {
    Cell[][] cells;

    public Board(int N,int snakeCount,int ladderCount) {
        initializeBoard(N);
        addSnakesAndLadders(snakeCount,ladderCount);
    }

    public void initializeBoard(int N) {
        // TODO : Initialize the board such that proper snake and ladder config happens
        cells = new Cell[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                cells[i][j] = new Cell();
            }
        }
    }

    public void addSnakesAndLadders(int snakeCount,int ladderCount) {
        // TODO : Add snake and ladders to the board
    }
}
