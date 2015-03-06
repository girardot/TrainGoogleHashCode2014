package fr.xebia.google.hashcode.instruction;

import fr.xebia.google.hashcode.structure.Cell;

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

}
