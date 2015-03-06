package fr.xebia.google.hashcode.instruction;

import fr.xebia.google.hashcode.structure.Cell;
import fr.xebia.google.hashcode.structure.Grid;
import fr.xebia.google.hashcode.structure.State;

public class EraseInstruction implements Instruction {

    private Cell cell;

    public EraseInstruction(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        return "ERASECELL " + cell;
    }

    @Override
    public void print(Grid grid) {
        grid.getCell(cell.getLine(), cell.getColumn()).setState(State.BLANK);
    }
}
