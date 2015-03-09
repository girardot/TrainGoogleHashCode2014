package fr.xebia.google.hashcode.structure;

import static fr.xebia.google.hashcode.structure.ColorTarget.COLORED;

public class Cell {

    private int line;

    private int column;

    private ColorTarget colorTarget;

    private AlgoState algoState = AlgoState.DOING;

    public Cell(ColorTarget colorTarget) {
        this.colorTarget = colorTarget;
    }

    public Cell(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public Cell(int line, int column, ColorTarget colorTarget) {
        this.line = line;
        this.column = column;
        this.colorTarget = colorTarget;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return line + " " + column;
    }

    public ColorTarget getColorTarget() {
        return colorTarget;
    }

    public void setState(ColorTarget colorTarget) {
        this.colorTarget = colorTarget;
    }

    public boolean isColored() {
        return COLORED.equals(this.colorTarget);
    }

    public boolean isDone() {
        return AlgoState.DONE.equals(this.algoState);
    }

    private enum AlgoState {
        DONE, DOING
    }
}
