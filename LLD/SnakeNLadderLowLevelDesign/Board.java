package LLD.SnakeNLadderLowLevelDesign;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int N,int snakeCount,int ladderCount) {
        initializeBoard(N);
        addSnakesAndLadders(snakeCount,ladderCount);
    }

    public void initializeBoard(int N) {
        cells = new Cell[N][N];
        int cellNumber = 0;
        for(int i=0;i<N;i++){
            if(i%2 == 0){
                for(int j=0;j<N;j++){
                    cells[i][j] = new Cell(null,cellNumber++);
                }
            } else {
                for(int j=N-1;j>=0;j--){
                    cells[i][j] = new Cell(null,cellNumber++);
                }
            }
        }

        System.out.println("Board initialized");
    }

    public void addSnakesAndLadders(int snakeCount,int ladderCount) {
        System.out.println("Adding snakes and ladders");
        
        while(snakeCount > 0){
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);

            if(start <= end){
                continue;
            }
            Jump snakeJump = new SnakeJump();
            snakeJump.start = start;
            snakeJump.end = end;

            Cell cell = getCell(start);
            cell.jump = snakeJump;

            snakeCount--;
        }

        while(ladderCount > 0){
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);

            if(start >= end){
                continue;
            }
            Jump ladderJump = new LadderJump();
            ladderJump.start = start;
            ladderJump.end = end;

            Cell cell = getCell(start);
            cell.jump = ladderJump;

            ladderCount--;
        }

    }

    public Cell getCell(int cellNumber) {
        Cell cell = null;
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[i].length;j++){
                if(cells[i][j].cellNumber == cellNumber){
                    cell = cells[i][j];
                }
            }
        }
        return cell;
    }

}
