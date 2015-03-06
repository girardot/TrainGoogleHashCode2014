package fr.xebia.google.hashcode.structure;

public class Grid {

    private final int lineSize;
    private final int columnSize;

    private Cell[] cells;

    public Grid(int lineSize, int columnSize) {
        this.lineSize = lineSize;
        this.columnSize = columnSize;

        cells = new Cell[lineSize * columnSize];
    }

    public Cell getCell(int lineNumber, int columnNumber) {
        return cells[lineNumber * columnSize + columnNumber];
    }

}
