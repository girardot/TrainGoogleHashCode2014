package fr.xebia.google.hashcode;

import fr.xebia.google.hashcode.instruction.Instruction;
import fr.xebia.google.hashcode.instruction.PaintInstruction;
import fr.xebia.google.hashcode.structure.Cell;
import fr.xebia.google.hashcode.structure.Grid;

import java.util.ArrayList;
import java.util.List;

public class Painter {

    public List<Instruction> createBasicInstructions(Grid grid) {
        List<Instruction> basicInstructions = new ArrayList<>();

        for (int lineNumber = 0; lineNumber < grid.getLineSize(); lineNumber++) {
            for (int columnNumber = 0; columnNumber < grid.getColumnSize(); columnNumber++) {
                Cell cell = grid.getCell(lineNumber, columnNumber);

                if (cell.isColored()) {
                    basicInstructions.add(new PaintInstruction(cell, 0));
                }
            }
        }

        return basicInstructions;
    }

}
