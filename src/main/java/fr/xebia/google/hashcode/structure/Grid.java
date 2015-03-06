package fr.xebia.google.hashcode.structure;

public class Grid {

    private final int lineSize;
    private final int columnSize;

    private Cell[] cells;

    public Grid(int lineSize, int columnSize) {
        this.lineSize = lineSize;
        this.columnSize = columnSize;

        cells = new Cell[lineSize * columnSize];

        init();
    }

    public void init() {
        for (int i = 0; i < lineSize * columnSize; i++) {
            cells[i] = new Cell(State.BLANK);
        }
    }

    public int getLineSize() {
        return lineSize;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public Cell getCell(int lineNumber, int columnNumber) {
        return cells[computeIndex(lineNumber, columnNumber)];
    }

    public void addCell(int index, String readChar) {
        this.cells[index] = new Cell(State.fromAssociatedChar(readChar));
    }

    int computeIndex(int lineNumber, int columnNumber) {
        return lineNumber * columnSize + columnNumber;
    }

    int[] computeCoordinates(int index) {
        int[] coordinates = new int[2];

        coordinates[0] = index / columnSize;
        coordinates[1] = index % columnSize;

        return coordinates;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < lineSize * columnSize; i++) {
            result += cells[i].getState().getAssociatedChar();
            if ((i +1) % columnSize == 0) {
                result += "\n";
            }
        }
        return result;
    }

}
