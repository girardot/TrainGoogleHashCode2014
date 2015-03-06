package fr.xebia.google.hashcode.structure;

public class Cell {

    private int line;

    private int column;

    private State state;

    public Cell(int line, int column) {
        this.line = line;
        this.column = column;
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

    public Cell(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

}
