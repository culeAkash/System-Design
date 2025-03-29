package LLD.SnakeNLadderLowLevelDesign;

public class Cell {
    Jump jump;
    int cellNumber;

    public Cell() {
        jump = null;
        cellNumber = 0;
    }

    public Cell(Jump jump,int cellNumber) {
        this.jump = jump;
        this.cellNumber = cellNumber;
    }
}
