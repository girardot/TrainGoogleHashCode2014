package fr.xebia.google.hashcode.instruction;

import fr.xebia.google.hashcode.structure.Cell;
import fr.xebia.google.hashcode.structure.ColorTarget;
import fr.xebia.google.hashcode.structure.Grid;

public class PaintInstruction implements Instruction {

    private Cell cell;

    private int size;

    public PaintInstruction(Cell cell, int size) {
        this.cell = cell;
        this.size = size;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PAINTSQ " + cell + " " + size;
    }

    @Override
    public void print(Grid grid) {
        for (int i = getCell().getLine() - getSize(); i <= getCell().getLine() + getSize(); i++) {
            for (int j = getCell().getColumn() - getSize(); j <= getCell().getColumn() + getSize(); j++) {
                grid.getCell(i, j).setState(ColorTarget.COLORED);
            }
        }
    }

//    private void drawSquare()

}
