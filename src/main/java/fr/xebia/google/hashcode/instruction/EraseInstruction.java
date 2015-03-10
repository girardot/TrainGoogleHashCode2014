package fr.xebia.google.hashcode.instruction;

import fr.xebia.google.hashcode.structure.Cell;
import fr.xebia.google.hashcode.structure.Grid;
import fr.xebia.google.hashcode.structure.ColorTarget;

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
        grid.getCell(cell.getLine(), cell.getColumn()).setState(ColorTarget.BLANK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EraseInstruction)) return false;

        EraseInstruction that = (EraseInstruction) o;

        if (cell != null ? !cell.equals(that.cell) : that.cell != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return cell != null ? cell.hashCode() : 0;
    }
}
