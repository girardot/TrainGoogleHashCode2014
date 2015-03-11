package fr.xebia.google.hashcode.structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Grid {

    private final int lineSize;
    private final int columnSize;

    private Cell[] cells;

    private int lastIndex = 0;

    public Grid(int lineSize, int columnSize) {
        this.lineSize = lineSize;
        this.columnSize = columnSize;

        cells = new Cell[lineSize * columnSize];

        init();
    }

    public void init() {
        for (int i = 0; i < lineSize * columnSize; i++) {
            cells[i] = new Cell(ColorTarget.BLANK);
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
        int[] coordinates = computeCoordinates(index);

        this.cells[index] = new Cell(coordinates[0], coordinates[1], ColorTarget.fromAssociatedChar(readChar));
    }

    public void pushCell(String readChar) {
        int[] coordinates = computeCoordinates(lastIndex);

        this.cells[lastIndex] = new Cell(coordinates[0], coordinates[1], ColorTarget.fromAssociatedChar(readChar));
        lastIndex++;
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

    public Iterator<Cell> iterator() {
        return new GridIterator(this);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < lineSize * columnSize; i++) {
            result += cells[i].getColorTarget().getAssociatedChar();
            if ((i + 1) % columnSize == 0) {
                result += "\n";
            }
        }
        return result;
    }

    private class GridIterator implements Iterator {

        private final Grid grid;
        private int lineNumber, columnNumber = 0;

        public GridIterator(Grid grid) {
            this.grid = grid;
        }

        @Override
        public boolean hasNext() {
            return lineNumber < grid.getLineSize() && columnNumber < grid.getColumnSize();
        }

        @Override
        public Cell next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int tempLineNumber = this.lineNumber;
            int tempColumnNumber = this.columnNumber;

            if (this.columnNumber + 1 == grid.getColumnSize()) {
                this.columnNumber = 0;
                this.lineNumber++;
            }
            else {
                this.columnNumber++;
            }

            return grid.getCell(tempLineNumber, tempColumnNumber);
        }
    }

}