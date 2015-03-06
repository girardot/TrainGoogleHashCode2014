package fr.xebia.google.hashcode.structure;

import static fr.xebia.google.hashcode.structure.State.COLORED;

public class Cell {

    private int line;

    private int column;

    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public Cell(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public Cell(int line, int column, State state) {
        this.line = line;
        this.column = column;
        this.state = state;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isColored() {
        return COLORED.equals(this.state);
    }
}
